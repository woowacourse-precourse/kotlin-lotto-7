package lotto.controller

import lotto.model.PurchaseAmount
import lotto.util.RepeatFunction
import lotto.view.InputView

class LottoController {
    fun run() {
        val purchaseAmount = getPurchaseAmount()
    }

    private fun getPurchaseAmount(): PurchaseAmount {
        return RepeatFunction.executeWithRetry {
            val purchaseAmount = InputView.inputPurchaseAmount()
            PurchaseAmount(purchaseAmount)
        }
    }
}
