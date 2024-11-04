package lotto.model

class LottoCalculator {
    fun calculateProfitRate(results: Map<Rank, Int>, purchasePrice: Int): String {
        val totalPrize = calculateTotalPrize(results)
        val profitRate = (totalPrize.toDouble() / purchasePrice) * 100
        return String.format("%.1f", profitRate)
    }

    private fun calculateTotalPrize(results: Map<Rank, Int>): Int {
        return results.entries.sumOf { (rank, count) -> rank.prize * count }
    }
}