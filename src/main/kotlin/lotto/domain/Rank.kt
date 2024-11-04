package lotto.domain

enum class Rank(
    val matchCount: Int,
    val bonusMatch: Boolean,
    val prize: Int,
) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0),
    ;

    companion object {
        private const val MAX_MATCH_COUNT = 5

        fun of(
            matchCount: Int,
            hasBonusMatch: Boolean = false,
        ): Rank =
            entries
                .filter { it != NONE }
                .findLast { rank ->
                    rank.matchCount == matchCount &&
                        (matchCount != MAX_MATCH_COUNT || rank.bonusMatch == hasBonusMatch)
                } ?: NONE
    }
}
