package lotto.model

enum class Rank(
    val matchCount: Int,
    val money: Int,
    val hasBonus: Boolean = false
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    companion object {
        private const val MATCH_COUNT_SIX = 6
        private const val MATCH_COUNT_FIVE = 5
        private const val MATCH_COUNT_FOUR = 4
        private const val MATCH_COUNT_THREE = 3

        fun matchRank(matchCount: Int, isBonusMatch: Boolean): Rank {
            return when (matchCount) {
                MATCH_COUNT_SIX -> FIRST
                MATCH_COUNT_FIVE -> if (isBonusMatch) SECOND else THIRD
                MATCH_COUNT_FOUR -> FOURTH
                MATCH_COUNT_THREE -> FIFTH
                else -> NONE
            }
        }
    }
}