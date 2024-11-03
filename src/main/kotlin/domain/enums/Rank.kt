package domain.enums

import domain.enums.Output.Companion.matchCountFormat
import domain.enums.Output.Companion.matchingNumberFormat
import domain.util.convertWithDigitComma

enum class Rank(
    private val reward: Int,
    private val matchCount: Int,
) {
    FIRST(2000000000, 6),
    SECOND(30000000, 5),
    THIRD(1500000, 5),
    FOURTH(50000, 4),
    FIFTH(5000, 3),
    NONE(0, 0);

    companion object {
        fun getRank(matchCount: Int, bonusMatched: Boolean): Rank {
            return when (matchCount) {
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

    fun getFormattedRankResult(winningCount: Int): String {
        val matchCount = this.matchCount
        val reward = this.reward.convertWithDigitComma()

        val matchCountFormat = matchCountFormat(matchCount)
        val matchingNumberFormat = matchingNumberFormat(reward, winningCount)

        if (this == SECOND) {
            return "$matchCountFormat${Output.BONUS_MATCH_COUNT} $matchingNumberFormat"
        }

        return "$matchCountFormat $matchingNumberFormat"
    }

    fun getReword(): Int = reward
}