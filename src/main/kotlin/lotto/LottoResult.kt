package lotto

import lotto.domain.Rank
import lotto.domain.WinningLotto

class LottoResult(
    private val lottos: List<Lotto>,
    private val winningLotto: WinningLotto,
    private val purchaseAmount: Int,
) {
    private val results: Map<Rank, Int> = calculateResults()

    fun getWinningStatistics(): Map<Rank, Int> = results.filterKeys { it != Rank.NONE }

    fun calculateProfitRate(): Double {
        val totalPrize = results.entries.sumOf { (rank, count) -> rank.prize * count }
        return (totalPrize.toDouble() / purchaseAmount * 100)
    }

    private fun calculateResults(): Map<Rank, Int> =
        lottos
            .map { lotto -> winningLotto.match(lotto) }
            .groupingBy { it }
            .eachCount()
}
