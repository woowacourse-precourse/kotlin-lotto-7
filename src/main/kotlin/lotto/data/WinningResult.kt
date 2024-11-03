package lotto.data

class WinningResult(
    private val lottoNumbers: List<List<Int>>,
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {
    val details: Map<Rank, Int>
    val profitRate: Double

    init {
        details = Rank.entries
            .filter { it != Rank.MISS }
            .associateWith { rank -> calculateRanks().count { it == rank } }

        profitRate = calculateProfitRate()
    }

    private fun calculateRanks() =
        lottoNumbers.map { numbers -> Rank.match(countMatches(numbers), containsBonus(numbers)) }

    private fun countMatches(numbers: List<Int>) = numbers.count { winningNumbers.contains(it) }

    private fun containsBonus(numbers: List<Int>) = numbers.contains(bonusNumber)

    private fun calculateProfitRate(): Double {
        val totalWinnings = details.entries.sumOf { it.value * it.key.winningPrize }
        val totalSpent = lottoNumbers.size * PRICE_PER_LOTTO
        return totalWinnings.toDouble() / totalSpent * 100.0
    }

    companion object {
        private const val PRICE_PER_LOTTO = 1_000
    }
}