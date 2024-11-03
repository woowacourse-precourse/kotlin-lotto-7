package lotto.domain

class LottoResult(private val ranks: Map<Rank, Int>) {
    fun getRankCounts(): Map<Rank, Int> = ranks

    fun calculateTotalPrize(): Long{
        return ranks.entries.sumOf { it.key.prizeMoney * it.value }
    }

    fun calculateYield(purchaseAmount: Int): Double {
        val totalPrize = calculateTotalPrize()
        return (totalPrize.toDouble() / purchaseAmount.toDouble()) * 100

    }
}