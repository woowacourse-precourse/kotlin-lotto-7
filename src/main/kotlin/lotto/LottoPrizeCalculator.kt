package lotto

import lotto.LottoConstants.HUNDRED
import lotto.LottoConstants.ONE_STEP
import kotlin.math.round

class LottoPrizeCalculator {
    fun calculateLottoResult(buyingPrice: Int, lottoRanks: List<MatchedCount>): LottoResult {
        val rankCounts = lottoRanks.countEachRank()
        val totalPrize = lottoRanks.sumPrizeValues()
        val earningsRate = (totalPrize.toEarningsRate(buyingPrice)).roundOneStep()
        return LottoResult(rankCounts, earningsRate)
    }

    private fun List<MatchedCount>.countEachRank(): Map<MatchedCount, Int> {
        return groupBy { it }
            .mapValues { it.value.size }
    }

    private fun List<MatchedCount>.sumPrizeValues() = sumOf { it.prize.toLong() }
    private fun Long.toEarningsRate(buyingPrice: Int) = (this / buyingPrice.toFloat()) * HUNDRED
    private fun Float.roundOneStep() = round(this / ONE_STEP) * ONE_STEP

}