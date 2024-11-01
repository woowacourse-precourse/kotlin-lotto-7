package lotto.model

class WinningRecord {
    fun createRecord(lottoResults: List<LottoRank>): List<Int> {
        val counts = lottoResults.groupingBy { it.rank }.eachCount()
        val labels = LottoRank.Rank.entries

        return labels.map { label ->
            counts.getOrDefault(label, 0)
        }
    }

    fun calculatorProfitRate(lottoResults: List<LottoRank>, purchaseAmount: Int): Double {
        val totalAmount = calculateTotalWinningAmount(lottoResults).toDouble()
        return totalAmount / purchaseAmount * 100.0
    }

    private fun calculateTotalWinningAmount(lottoResults: List<LottoRank>): Int =
        lottoResults.sumOf { it.winningAmount }
}