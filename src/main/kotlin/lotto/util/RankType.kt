package lotto.util

enum class RankType(
    val matchCount: Int,
    val prize: Int
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    companion object {
        fun getRankType(matchCount: Int, hasBonus: Boolean): RankType {
            return when {
                matchCount == FIRST.matchCount -> FIRST
                matchCount == SECOND.matchCount && hasBonus -> SECOND
                matchCount == THIRD.matchCount && !hasBonus -> THIRD
                matchCount == FOURTH.matchCount -> FOURTH
                matchCount == FIFTH.matchCount -> FIFTH
                else -> NONE
            }
        }
    }
}
