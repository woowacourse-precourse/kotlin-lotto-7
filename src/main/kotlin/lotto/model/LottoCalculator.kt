package lotto.model

class LottoCalculator {
    fun getLottoResults(tickets: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Map<Rank, Int> {
        val lottoResult = LottoResult()

        tickets.forEach { ticket ->
            val rank = Rank.from(
                matchCount = ticket.countMatchingNumbers(winningNumbers),
                matchBonus = ticket.containsBonusNumber(bonusNumber)
            )
            lottoResult.addResult(rank)
        }
        return lottoResult.getResults()
    }

    fun calculateProfitRate(results: Map<Rank, Int>, purchasePrice: Int): String {
        val totalPrize = calculateTotalPrize(results)
        val profitRate = (totalPrize.toDouble() / purchasePrice) * 100
        return String.format("%.1f", profitRate)
    }

    private fun calculateTotalPrize(results: Map<Rank, Int>): Int {
        return results.entries.sumOf { (rank, count) -> rank.prize * count }
    }
}