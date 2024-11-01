package lotto.model

class LottoResultCalculator(private val lotteries: List<Lotto>) {
    fun getLottoResults(winningNumbers: List<Int>, bonusNumber: Int): List<LottoResult> {
        val lotteriesRank = calculateRanks(winningNumbers, bonusNumber)
        val rankWithCounts = countRank(lotteriesRank)
        val lottoResults = mapToResult(rankWithCounts)

        return lottoResults
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
        val lottoResult = (1..5).map { rank ->
                val count = rankWithCounts.getOrDefault(rank, 0)
                LottoResult(rank, count)
            }
        return lottoResult
    }

    fun getLottoYield(lottoResults: List<LottoResult>, purchaseAmount: Int): String {
        val totalPrice = calculateTotalPrice(lottoResults)
        val yield = (totalPrice / purchaseAmount) * 100F
        val formattedYield = String.format("%,.2f", yield)

        return formattedYield
    }

    private fun calculateTotalPrice(lottoResults: List<LottoResult>): Int {
        var totalPrice = 0
        lottoResults.forEach { lottoResult ->
            val price = getPrice(lottoResult.rank)
            val count = lottoResult.count
            totalPrice += price * count
        }
        return totalPrice
    }

    private fun getPrice(rank: Int): Int {
        return when (rank) {
            1 -> 2000000000
            2 -> 30000000
            3 -> 1500000
            4 -> 50000
            5 -> 5000
            else -> 0
        }
    }
}

data class LottoResult(
    val rank: Int,
    val count: Int,
)