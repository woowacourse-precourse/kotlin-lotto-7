package lotto

enum class MatchedCount(val prize: Int) {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000),
    NONE(0);

    companion object {
        fun fromMatchedNumbers(matchedNumbers: Int, isBonusNumberMatched: Boolean): MatchedCount {
            return when (matchedNumbers) {
                6 -> MatchedCount.FIRST
                5 -> if (isBonusNumberMatched) MatchedCount.SECOND else MatchedCount.THIRD
                4 -> MatchedCount.FOURTH
                3 -> MatchedCount.FIFTH
                else -> MatchedCount.NONE
            }
        }
    }
}