package lotto.domain

enum class Rank(
    private val matchCount: Int,
    private val prize: Int,
    private val needBonusMatch: Boolean = false,
) {
    FIRST(
        matchCount = 6,
        prize = 2_000_000_000
    ),
    SECOND(
        matchCount = 5,
        prize = 30_000_000,
        needBonusMatch = true
    ),
    THIRD(
        matchCount = 5,
        prize = 1_500_000
    ),
    FOURTH(
        matchCount = 4,
        prize = 50_000
    ),
    FIFTH(
        matchCount = 3,
        prize = 5_000
    ),
    NONE(
        matchCount = 0,
        prize = 0
    );

    fun getPrize() = prize

    companion object {

        fun findByMatch(matchCount: Int, bonusMatch: Boolean): Rank =
            when {
                matchCount == 6 -> FIRST
                matchCount == 5 && bonusMatch -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> NONE
            }

    }
}
