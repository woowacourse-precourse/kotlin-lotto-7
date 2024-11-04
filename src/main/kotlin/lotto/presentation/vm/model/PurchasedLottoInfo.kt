package lotto.presentation.vm.model

import lotto.domain.util.formatPurchasedLotto
import java.util.TreeSet

data class PurchasedLottoInfo(
    val pickedLotto: List<TreeSet<Int>> = emptyList(),
) {
    val guideMessage: String get() = formatPurchasedLotto(pickedLotto)
}