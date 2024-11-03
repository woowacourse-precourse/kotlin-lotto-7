package lotto.utils

import lotto.constants.Constants
import lotto.model.Rank
import lotto.model.Stat

object StatCalculator {
    fun getProfitRate(stats: List<Stat>, price: Int): String {
        var profit = 0
        stats.forEach { stat ->
            val rank = stat.getRank()
            val count = stat.getCount()
            profit += rank.winningPrice * count
        }
        return String.format("%.1f", profit / price.toDouble() * Constants.PERCENT)
    }

    fun getRank(numbers: List<Int>, winningNumber: Set<Int>, bonusNumber: Int): Rank {
        var matchedNumber = 0
        var matchBonusNumber = false
        numbers.forEach { num ->
            if(winningNumber.contains(num)) matchedNumber++
            if(num == bonusNumber) matchBonusNumber = true
        }
        return getRankFromMatchedNumber(matchedNumber, matchBonusNumber)
    }

    private fun getRankFromMatchedNumber(matchedNumber: Int, matchBonusNumber: Boolean): Rank {
        return when(matchedNumber) {
            Rank.FIFTH.matchedNumber -> Rank.FIFTH
            Rank.FOURTH.matchedNumber -> Rank.FOURTH
            Rank.THIRD.matchedNumber -> if(matchBonusNumber) Rank.SECOND else Rank.THIRD
            Rank.FIRST.matchedNumber -> Rank.FIRST
            else -> Rank.NONE
        }
    }
}