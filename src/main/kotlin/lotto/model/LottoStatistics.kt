package lotto.model

class LottoStatistics {
    fun calculateStatistics(
        issuedLottos: List<Lotto>,
        winningNumbers: List<Int>,
        bonusNumber: Int
    ): Map<Rank, Int> {
        val statistics = mutableMapOf<Rank, Int>()

        for (lotto in issuedLottos) {
            val rank = lotto.compareWithWinningNumbers(winningNumbers, bonusNumber)
            statistics[rank] = statistics.getOrDefault(rank, 0) + 1
        }

        return statistics
    }

    fun calculateYield(statistics: Map<Rank, Int>, totalSpent: Int): Double {
        val totalPrize = statistics.entries.sumOf { (rank, count) -> rank.prize * count }
        return if (totalSpent == 0) 0.0 else (totalPrize.toDouble() / totalSpent) * 100 // 수익률 계산
    }
}
