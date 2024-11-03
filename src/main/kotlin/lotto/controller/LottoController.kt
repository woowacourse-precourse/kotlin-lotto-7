package lotto.controller

import lotto.service.LottoService
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottoService = LottoService()

    fun run() {
        val purchaseAmount = inputView.getPurchaseAmount()
        val lottos = lottoService.purchaseLottos(purchaseAmount)
        outputView.printLottos(lottos)
        val winningNumbers = inputView.getWinningNumbers()
        val bonusNumber = inputView.getBonusNumber(winningNumbers)
        val statistics = lottoService.calculateStatistics(lottos, winningNumbers, bonusNumber)
        outputView.printStatistics(statistics, purchaseAmount)
    }
}