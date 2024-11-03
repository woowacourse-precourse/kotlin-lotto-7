package lotto

import lotto.domain.Lotto
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

    }

}