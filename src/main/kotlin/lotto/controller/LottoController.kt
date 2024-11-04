package lotto.controller

import lotto.model.LottoService
import lotto.utils.Constants
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val lottoService: LottoService) {

    fun start() {
        val lottoAmount = InputView.getLottoAmount()

        val lottoCount = lottoAmount / Constants.LOTTO_PRICE
        OutputView.printLottoAmountMessage(lottoCount)

        val lottoTickets = lottoService.generateLottoTickets(lottoCount)
        OutputView.printLottoNumber(lottoTickets)

        val winningNumbers = InputView.getWinningNumbers()
        val bonusNumber = InputView.getBonusNumber(winningNumbers)

        val lottoRanks = lottoService.calculateMatchingNumbers(lottoTickets, winningNumbers, bonusNumber)
        val rankCount = lottoRanks.distinct().associateWith { rank -> lottoRanks.count { it == rank } }

        OutputView.printResult(rankCount)

        val profit = lottoService.calculateProfit(rankCount, lottoAmount)
        OutputView.printProfit(profit)
    }

}