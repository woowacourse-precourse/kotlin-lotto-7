package lotto.utils

import lotto.model.Stat

class ProfitRateCalculator {
    fun calculate(stats: List<Stat>, price: Int): String {
        var profit = 0
        stats.forEach { stat ->
            val rank = stat.getRank()
            val count = stat.getCount()
            profit += rank.winningPrice * count
        }
        return String.format("%.1f", profit / price.toDouble() * 100)
    }
}