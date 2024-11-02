package lotto.adapter

import lotto.domain.model.PurchaseAmount

object PurchaseAmountAdapter {
    fun toPurchaseAmountModel(input: String): PurchaseAmount {
        val purchaseAmount: Int = input.toInt()
        return PurchaseAmount(purchaseAmount)
    }
}