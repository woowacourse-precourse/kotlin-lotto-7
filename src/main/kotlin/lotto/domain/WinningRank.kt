package lotto.domain

enum class WinningRank(val matchCount: Int, val prize: Int) {
    THREE_MATCH(3, 5_000),
    FOUR_MATCH(4, 50_000),
    FIVE_MATCH(5, 1_500_000),
    FIVE_MATCH_WITH_BONUS(5, 30_000_000),
    SIX_MATCH(6, 2_000_000_000),
    NO_MATCH(0, 0);

    companion object {
        fun findByMatch(count: Int, matchBonus: Boolean = false): WinningRank {
            return when {
                count == 6 -> SIX_MATCH
                count == 5 && matchBonus -> FIVE_MATCH_WITH_BONUS
                count == 5 -> FIVE_MATCH
                count == 4 -> FOUR_MATCH
                count == 3 -> THREE_MATCH
                else -> NO_MATCH
            }
        }
    }
}