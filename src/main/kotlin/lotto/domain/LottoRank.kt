package lotto.domain

enum class LottoRank(val prize: Int, val matchCount: Int, val bonusMatch: Boolean) {
    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FOURTH(50_000, 4, false),
    FIFTH(5_000, 3, false),
    NONE(0, 2, false);

    companion object {
        fun getRank(matchCount: Int, bonusMatch: Boolean): LottoRank {
            return when {
                matchCount == FIRST.matchCount -> FIRST
                matchCount == SECOND.matchCount && SECOND.bonusMatch == bonusMatch -> SECOND
                matchCount == THIRD.matchCount -> THIRD
                matchCount == FOURTH.matchCount -> FOURTH
                matchCount == FIFTH.matchCount -> FIFTH
                else -> NONE
            }
        }
    }
}