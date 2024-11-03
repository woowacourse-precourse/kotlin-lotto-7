package lotto.presentation.vm.model

import lotto.domain.enums.Output.Companion.purchaseFormat

data class PurchaseInfo(
    val purchaseLottoCount: Int = 0,
){
    val guideMessage: String
        get() = purchaseFormat(purchaseLottoCount)
}