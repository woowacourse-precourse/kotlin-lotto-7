package domain.model

import domain.enums.Rank

data class WinningState (
    val winning: MutableMap<Rank, Int> = mutableMapOf(
        Rank.FIFTH to 0,
        Rank.FOURTH to 0,
        Rank.THIRD to 0,
        Rank.SECOND to 0,
        Rank.FIRST to 0,
    )
)