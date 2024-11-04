package lotto.controller

import lotto.domain.numberGenerator.NumberGenerator
import lotto.domain.purchase.Purchase
import lotto.view.purchaseAmountView

class LottoController(numberGenerator: NumberGenerator) {
    fun draw() {
        val purchase = getPurchaseAmount()
    }

    private fun getPurchaseAmount(): Purchase {
        return runCatching {
            Purchase.valueOf(purchaseAmountView())
        }.onFailure { exception ->
            println(exception.message)
        }.getOrElse {
            getPurchaseAmount()
        }
    }
}