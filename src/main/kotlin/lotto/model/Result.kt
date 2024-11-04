package lotto.model

import lotto.util.RankType

class Result(private val rankCount: Map<RankType, Int>) {
    fun calculateProfitRate(money: Money): String {
        val totalPrize = calculateTotalPrize()
        val profitRate = if (money.amount > 0) (totalPrize.toDouble() / money.amount) * 100 else 0.0
        return String.format("%.1f", profitRate)
    }

    private fun calculateTotalPrize(): Int = rankCount.entries.sumOf { (rank, count) -> rank.prize * count }
}
