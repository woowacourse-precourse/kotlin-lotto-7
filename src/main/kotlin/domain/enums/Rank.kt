package domain.enums

enum class Rank(
    private val reword: Int,
    private val matchingCount: Int,
) {
    FIRST(2000000000, 6),
    SECOND(30000000, 5),
    THIRD(1500000, 5),
    FOURTH(50000, 4),
    FIFTH(5000, 3),
    NONE(0,0);

    companion object {
        fun getRank(matchingCount: Int, bonusMatched: Boolean): Rank {
            return when (matchingCount) {
                6 -> FIRST
                5 -> getRankByBonusMatched(bonusMatched)
                4 -> FOURTH
                3 -> FIFTH
                else -> NONE
            }
        }

        private fun getRankByBonusMatched(bonusMatched: Boolean): Rank {
            if (bonusMatched) return SECOND
            return THIRD
        }
    }

    fun getReword(): Int = reword
    fun getMatchingCount(): Int = matchingCount
}