package domain.model

import java.util.TreeSet

data class PurchaseState (
    val purchaseLottoCount: Int = 0,
    val winningNumber: List<Int> = emptyList(),
    val bonusNumber: Int = 0,
    val pickedLotto: List<TreeSet<Int>> = emptyList(),
)