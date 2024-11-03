package lotto.presentation.vm.model

import lotto.domain.enums.Rank
import java.util.TreeSet

data class PurchaseState(
    val purchaseLottoCount: Int = 0,
    val winningNumber: List<Int> = emptyList(),
    val bonusNumber: Int = 0,
    val pickedLotto: List<TreeSet<Int>> = emptyList(),
    val winningResult: Map<Rank, Int> = mapOf(
        Rank.FIFTH to 0,
        Rank.FOURTH to 0,
        Rank.THIRD to 0,
        Rank.SECOND to 0,
        Rank.FIRST to 0,
    ),
    val rateOfReturn: String = "0.0"
)