package lotto.controller

import lotto.Constants.ERROR_INVALID_LOTTO_PURCHASE_MESSAGE
import lotto.view.InputView
import lotto.view.OutputView
import lotto.Validator
import lotto.model.BonusNumber
import lotto.Lotto
import lotto.model.LottoGenerator
import lotto.model.LottoRank
import lotto.model.Profit

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val validator = Validator()
    private val generator = LottoGenerator()
    private val profit = Profit()

    fun lottoGame() {
        val purchaseAmount = getLottoPurchaseAmount()
        val ticket = countLottoTicket(purchaseAmount)
        val lottoTickets = generateLottoTickets(ticket)
        outputView.countTicketsMessage(ticket)
        outputView.generateTicketsMessage(lottoTickets)
        val winLottoNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber(winLottoNumbers)
        calculateWinningStatistics(lottoTickets, winLottoNumbers, bonusNumber.toInt())
        showProfitPercentage(purchaseAmount)
    }

    private fun getLottoPurchaseAmount(): Int {
        return try {
            val lottoPurchase = inputView.purchaseLottoMessage()
            validator.checkLottoPurchaseAmount(lottoPurchase)
            lottoPurchase.toInt()
        } catch (e: NumberFormatException) {
            print(ERROR_INVALID_LOTTO_PURCHASE_MESSAGE)
            getLottoPurchaseAmount()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getLottoPurchaseAmount()
        }
    }

    private fun countLottoTicket(purchaseAmount: Int): Int {
        return purchaseAmount / 1000
    }

    private fun generateLottoTickets(ticket: Int): List<List<Int>> {
        return generator.generateLottoTickets(ticket)
    }

    private fun getWinningNumbers(): List<Int> {
        return try {
            val winningNumbers = inputView.getWinLottoNumbers()
            Lotto(winningNumbers).getWinningNumbers()
        } catch (error: NumberFormatException) {
            print(ERROR_INVALID_LOTTO_PURCHASE_MESSAGE)
            getWinningNumbers()
        } catch (error: IllegalArgumentException) {
            getWinningNumbers()
        }
    }

    private fun getBonusNumber(lotto: List<Int>): String {
        return try {
            val bonusNumber = inputView.getBonusNumber()
            BonusNumber(bonusNumber, lotto).getBonusNumber()
        } catch (error: NumberFormatException) {
            print(ERROR_INVALID_LOTTO_PURCHASE_MESSAGE)
            getBonusNumber(lotto)
        } catch (error: IllegalArgumentException) {
            getBonusNumber(lotto)
        }
    }

    private fun calculateWinningStatistics(lottoTickets: List<List<Int>>, winningNumbers: List<Int>, bonusNumber: Int) {
        lottoTickets.forEach { ticket ->
            val matchCount = ticket.count { winningNumbers.contains(it) }
            val hasBonusMatch = ticket.contains(bonusNumber)

            val rank = LottoRank.fromMatch(matchCount, hasBonusMatch)
            rank?.increment()
        }
        outputView.displayWinningMessage()
    }

    private fun showProfitPercentage(purchaseAmount: Int) {
        val profitPercentage = profit.calculateProfitPercentage(purchaseAmount)
        outputView.displayProfitPercentage(profitPercentage)
    }

}