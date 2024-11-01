package lotto.utils

import lotto.model.Rank

class ProfitRateCalculator {
    fun getProfitRate(rankCount: Map<Rank, Int>, price: Int): String {
        var profit = 0
        rankCount.forEach { (rank, count) ->
            profit += rank.winningPrice * count
        }
        return String.format("%.1f", profit / price.toDouble() * 100)
    }
}