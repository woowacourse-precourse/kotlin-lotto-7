package lotto.presentation.vm.model

import lotto.domain.enums.Rank
import lotto.domain.util.formatWinningResult

data class WinningResult (
    val winning: Map<Rank, Int> = mapOf(
        Rank.FIFTH to 0,
        Rank.FOURTH to 0,
        Rank.THIRD to 0,
        Rank.SECOND to 0,
        Rank.FIRST to 0,
    )
){
    val guideMessage: String get() = formatWinningResult(winning)
}