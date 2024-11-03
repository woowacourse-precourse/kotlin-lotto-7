package lotto.presentation.vm.model

import lotto.domain.util.ext.joinToStringWithSquareBracket
import java.util.TreeSet

data class PurchasedLottoInfo(
    val pickedLotto: List<TreeSet<Int>> = emptyList(),
) {
    val guideMessage: String
        get() = pickedLotto.joinToString(",\n") {
            it.joinToStringWithSquareBracket()
        }
}