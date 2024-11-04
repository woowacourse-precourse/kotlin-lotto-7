package lotto.domain

enum class Rank(
    private val matchCount: Int,
    private val bonusMatch: Boolean,
    val prize: Int,
    private val description: String,
) {
    FIRST(6, false, 2_000_000_000, "6개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, false, 1_500_000, "5개 일치"),
    FOURTH(4, false, 50_000, "4개 일치"),
    FIFTH(3, false, 5_000, "3개 일치"),
    NONE(0, false, 0, ""),
    ;

    fun getWinningStatistic(): String {
        if (this == NONE) return ""
        return "$description (${prize}원)"
    }

    companion object {
        fun of(
            matchCount: Int,
            hasBonusMatch: Boolean = false,
        ): Rank =
            entries.find { rank ->
                rank.matchCount == matchCount && rank.bonusMatch == hasBonusMatch
            } ?: NONE
    }
}
