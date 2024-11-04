package lotto.domain

data class WinningStatus(
    val rankCount: Map<Rank, Int>,
    val profitRate: Double
)