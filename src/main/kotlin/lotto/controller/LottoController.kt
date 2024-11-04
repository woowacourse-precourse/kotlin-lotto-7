package lotto.controller

import lotto.model.*
import lotto.util.RankType
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun run() {
        val money = getPurchaseAmount()
        val lottoMachine = generateLottoTickets(money)
        showLottoTickets(lottoMachine)
        val lotto = inputWinningLottoNumbers()
        val bonusNumber = inputBonusNumber(lotto)
        val rank = calculateRank(lotto, bonusNumber, lottoMachine)
        showResult(money, rank)
    }

    private fun getPurchaseAmount(): Money {
        while (true) {
            try {
                val inputAmount = tryGettingPurchaseAmount()
                return Money(inputAmount)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun tryGettingPurchaseAmount(): Int {
        OutputView.printAmountMessage()
        return InputView.getSingleDigit()
    }

    private fun generateLottoTickets(money: Money): LottoMachine {
        OutputView.printPurchaseCountMessage(money.getLottoCount())
        return LottoMachine(money)
    }

    private fun showLottoTickets(lottoMachine: LottoMachine) {
        val lottoTicketDTOList = lottoMachine.generateLottoTicketDTOList()
        lottoTicketDTOList.forEach { lottoTicketDTO ->
            OutputView.printTicketMessage(lottoTicketDTO.numbers)
        }
    }

    private fun inputWinningLottoNumbers(): Lotto {
        while (true) {
            try {
                val lottoNumbers = tryGettingWinningLottoNumbers()
                return Lotto(lottoNumbers.map { LottoNumber(it) })
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun tryGettingWinningLottoNumbers(): List<Int> {
        OutputView.printWinningNumberMessage()
        return InputView.getMultipleDigit()
    }

    private fun inputBonusNumber(lotto: Lotto): BonusNumber {
        while (true) {
            try {
                val number = tryGettingBonusNumber()
                return BonusNumber(number, lotto)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun tryGettingBonusNumber(): Int {
        OutputView.printBonusNumberMessage()
        return InputView.getSingleDigit()
    }

    private fun calculateRank(lotto: Lotto, bonusNumber: BonusNumber, lottoMachine: LottoMachine): Map<RankType, Int> {
        val rankCalculator = RankCalculator(lotto, bonusNumber, lottoMachine)
        return rankCalculator.calculateRank()
    }

    private fun showResult(money: Money, rank: Map<RankType, Int>) {
        val result = Result(rank)
        OutputView.printStatistics(rank)
        OutputView.printProfitRate(result.calculateProfitRate(money))
    }
}
