package lotto.presentation.vm.model

import lotto.domain.util.formatPurchaseInfo

data class PurchaseInfo(
    val purchaseLottoCount: Int = 0,
){
    val guideMessage: String get() = formatPurchaseInfo(purchaseLottoCount)
}