package lotto.adapter

import lotto.domain.model.PurchaseInfo

object PurchaseInfoAdapter {
    fun makePurchaseInfoModel(input: String): PurchaseInfo {
        val purchaseAmount: Int = input.toInt()
        return PurchaseInfo(purchaseAmount)
    }
}