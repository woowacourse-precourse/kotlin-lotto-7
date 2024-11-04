package lotto.Model

import lotto.Lotto
import kotlin.math.round

class LottoRankResultsAnnouncer(
    private val releasedLottos: List<Lotto>,
    private val winningLottoResult: WinningLottoResult
) {
    fun getLottoRankResults(): Map<LottoRank, Int> {
        val lottoRankResults = mutableListOf<LottoRank>()
        releasedLottos.forEach { lotto: Lotto ->
            lottoRankResults.add(lotto.getLottoResult(winningLottoResult))
        }
        val lottoRankResultsWithCount = lottoRankResults.groupingBy { it }.eachCount()
        return lottoRankResultsWithCount
    }

    fun calculateTotalRateOfReturn(lottoRankResults: Map<LottoRank, Int>): Double {
        var totalWinningPrize = 0L
        lottoRankResults.forEach { currentRank ->
            val currentRankPrize = currentRank.key.prize
            val count = currentRank.value
            totalWinningPrize += currentRankPrize.toLong() * count.toLong()
        }
        val totalRateOfReturn = getTotalRateOfReturn(totalWinningPrize, releasedLottos.size)
        return totalRateOfReturn
    }

    private fun getTotalRateOfReturn(totalWinningPrize: Long, lottoAmount: Int): Double {
        val rawTotalRateOfReturn = totalWinningPrize.toDouble() / (lottoAmount * Lotto.COST).toDouble() * 100
        val totalRateOfReturn = round(rawTotalRateOfReturn * 10) / 10
        return totalRateOfReturn
    }
}