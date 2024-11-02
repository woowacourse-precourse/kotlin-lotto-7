package lotto.controller

import lotto.Constants
import lotto.model.LottoService
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val lottoService: LottoService) {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun start() {
        val lottoAmount = inputView.getLottoAmount()

        val lottoCount = lottoAmount / Constants.LOTTO_PRICE
        outputView.printLottoAmountMessage(lottoCount)

        val lottoTickets = lottoService.generateLottoTickets(lottoCount)
        outputView.printLottoNumber(lottoTickets)

        val winningNumbers = inputView.getWinningNumbers()
        val bonusNumber = inputView.getBonusNumber(winningNumbers)

        val lottoRanks = lottoService.calculateMatchingNumbers(lottoTickets, winningNumbers, bonusNumber)
        val rankCount = lottoRanks.distinct().associateWith { rank -> lottoRanks.count { it == rank } }

        outputView.printResult(rankCount)

    }

}