package lotto.Controller

import lotto.View.InputView

class LottoController {
    private val inputView = InputView()

    fun getInputs() {
        val purchaseAmount = inputView.getPurchaseAmount()
        val winningNumbers = inputView.getWinningNumbers()
        val bonusNumber = inputView.getBonusNumber()
    }
}