package lotto.domain

enum class Rank(
    val matchCount: Int,
    val isBonusMatch: Boolean,
    val prize: Int,
    val description: String

) {
    FIRST(6, false, 2_000_000_000, "6개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, false, 1_500_000, "5개 일치"),
    FOURTH(4, false, 50_000, "4개 일치"),
    FIFTH(3, false, 5_000, "3개 일치"),
    NONE(0, false, 0, "낙첨");

    companion object {
        fun calculate(matchCount: Int, bonusMatch: Boolean): Rank {
            if (matchCount == 6) return FIRST
            if (matchCount == 5 && bonusMatch) return SECOND
            if (matchCount == 5) return THIRD
            if (matchCount == 4) return FOURTH
            if (matchCount == 3) return FIFTH
            return NONE
        }
    }
}