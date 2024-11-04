package lotto.model

import lotto.util.constant.LottoRules

class LottoResultCalculator(private val lotteries: List<Lotto>) {
    fun getLottoResults(winningNumbers: List<Int>, bonusNumber: Int): List<LottoResult> {
        val lotteriesRank = calculateRanks(winningNumbers, bonusNumber)
        val rankWithCounts = countRank(lotteriesRank)
        val lottoResults = mapToResult(rankWithCounts)

        return lottoResults
    }

    fun getLottoYield(lottoResults: List<LottoResult>, purchaseAmount: Int): String {
        val totalEarnings = calculateTotalEarnings(lottoResults)
        val yield = (totalEarnings / purchaseAmount) * LottoRules.PERCENTAGE
        val formattedYield = String.format(LottoRules.YIELD_FORMAT, yield)

        return formattedYield
    }

    private fun calculateRanks(winningNumbers: List<Int>, bonusNumber: Int): List<Int> {
        val lotteriesRank = lotteries.map { lotto -> lotto.getLottoRank(winningNumbers, bonusNumber) }
        return lotteriesRank
    }

    private fun countRank(lotteriesRank: List<Int>): Map<Int, Int> {
        val rankWithCounts = lotteriesRank.groupingBy { it }.eachCount()
        return rankWithCounts
    }

    private fun mapToResult(rankWithCounts: Map<Int, Int>): List<LottoResult> {
        val lottoResult = (LottoRules.RANK_FIRST..LottoRules.RANK_FIFTH).map { rank ->
                val count = rankWithCounts.getOrDefault(rank, LottoRules.ZERO)
                LottoResult(rank, count)
            }
        return lottoResult
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
        return when (rank) {
            LottoRules.RANK_FIRST -> LottoRules.FIRST_PRIZE_MONEY
            LottoRules.RANK_SECOND -> LottoRules.SECOND_PRIZE_MONEY
            LottoRules.RANK_THIRD -> LottoRules.THIRD_PRIZE_MONEY
            LottoRules.RANK_FOURTH -> LottoRules.FOURTH_PRIZE_MONEY
            LottoRules.RANK_FIFTH -> LottoRules.FIFTH_PRIZE_MONEY
            else -> LottoRules.OUT_OF_RANK
        }
    }
}

data class LottoResult(
    val rank: Int,
    val count: Int,
)