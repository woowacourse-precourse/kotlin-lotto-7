package lotto.model

import lotto.util.constant.LottoRules

class LottoResultCalculator(private val lotteries: List<Lotto>) {

    fun getLottoResults(winningNumbers: List<Int>, bonusNumber: Int): List<LottoResult> {
        val lotteriesRank = calculateRanks(winningNumbers, bonusNumber)
        val rankWithCounts = countRank(lotteriesRank)
        val lottoResults = mapToResult(rankWithCounts)

        return lottoResults
    }

    private fun calculateRanks(winningNumbers: List<Int>, bonusNumber: Int): List<LottoRank> {
        val lotteriesRank = lotteries.map { lotto -> lotto.getLottoRank(winningNumbers, bonusNumber) }
        return lotteriesRank
    }

    private fun countRank(lotteriesRank: List<LottoRank>): Map<LottoRank, Int> {
        val rankWithCounts = lotteriesRank.groupingBy { it }.eachCount()
        return rankWithCounts
    }

    private fun mapToResult(rankWithCounts: Map<LottoRank, Int>): List<LottoResult> {
        val lottoResult = LottoRank.entries
            .filter { it != LottoRank.OUT_OF_RANK }
            .map { rank ->
                val count = rankWithCounts.getOrDefault(rank, LottoRules.ZERO)
                LottoResult(rank.rankNumber, count)
            }
        return lottoResult
    }

    fun getLottoYield(lottoResults: List<LottoResult>, purchaseAmount: Int): String {
        val totalEarnings = calculateTotalEarnings(lottoResults)
        val yield = (totalEarnings / purchaseAmount) * LottoRules.PERCENTAGE
        val formattedYield = String.format(LottoRules.YIELD_FORMAT, yield)

        return formattedYield
    }

    private fun calculateTotalEarnings(lottoResults: List<LottoResult>): Float {
        var totalEarnings = LottoRules.ZERO_FLOAT
        lottoResults.forEach { lottoResult ->
            val prizeMoney = getPrizeMoney(lottoResult.rank)
            val count = lottoResult.count
            totalEarnings += prizeMoney * count
        }
        return totalEarnings
    }

    private fun getPrizeMoney(rank: Int): Int {
        val prizeMoney = LottoRank.entries.find { it.rankNumber == rank }?.prizeMoney ?: LottoRules.OUT_OF_RANK
        return prizeMoney
    }
}

data class LottoResult(
    val rank: Int,
    val count: Int,
)