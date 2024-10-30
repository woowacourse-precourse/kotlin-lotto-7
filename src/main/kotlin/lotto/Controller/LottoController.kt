package lotto.Controller

import lotto.Model.InputValidater
import lotto.View.InputView

class LottoController {
    private val inputView = InputView()

    fun getInputs() {
        val lottoAmount = getPurchaseInput()
        val winningLotto = inputView.getWinningNumbers()
        val bonusNumber = inputView.getBonusNumber()
    }

    private fun getPurchaseInput(): Int {
        while (true) {
            try {
                val purchaseAmount = inputView.getPurchaseAmount()
                InputValidater.validatePurchaseAmount(purchaseAmount)
                return purchaseAmount.toInt() / 1000
            } catch (e: IllegalArgumentException) {
                println(e)
            }
        }
    }
}