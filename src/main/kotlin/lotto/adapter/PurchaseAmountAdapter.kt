package lotto.adapter

import lotto.PurchaseAmount

object PurchaseAmountAdapter {
    fun toPurchaseAmountModel(input: String): PurchaseAmount {
        val purchaseAmount: Int = input.toInt()
        return PurchaseAmount(purchaseAmount)
    }
}