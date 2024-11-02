package lotto.controller

import lotto.view.InputView

class LottoController {
    fun start() {
        val purchaseMoney = InputView.inputPurchaseMoney()
        val winningNumbers = InputView.inputWinningNumber()
    }
}