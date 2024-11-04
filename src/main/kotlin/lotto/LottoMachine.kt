package lotto

import lotto.view.InputView
import lotto.view.OutputView

class LottoMachine(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val lottoService: LottoService
) {
    fun start() {
        // 1. 로또 구입 기능
        val money = inputView.readPurchaseAmount()
        val quantity = lottoService.calculateQuantity(money)
        outputView.printPurchaseAmount(quantity)

        // 2. 로또 발행 기능
        val lottos = lottoService.generateLottos(quantity)
        outputView.printLottoStatus(lottos)

        // 3. 당첨 확인 기능
        val winningNumber = inputView.readWinningNumbers()
        val bonusNumber = inputView.readBonusNumber(winningNumber)
        val result = lottoService.checkWinning(lottos, winningNumber, bonusNumber)
        outputView.printStatistics(result)

    }

}