package lotto.adapter

import lotto.domain.model.PurchaseInfo

object PurchaseInfoAdapter {
    fun toPurchaseInfoModel(input: String): PurchaseInfo {
        val purchaseAmount: Int = input.toInt()
        return PurchaseInfo(purchaseAmount)
    }
}