package lotto.domain

class LottoResult(
    private val lottos: List<Lotto>,
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int,
) {

    private val statistics = LottoStatistics()

    init {
        findRankResult(lottos)
    }

    fun getRankCount(): Map<Rank, Int> =
        Rank.entries.associateWith { statistics.getRankCount(it) }

    fun getTotalPrize(): Long = statistics.getTotalPrize()

    private fun findRankResult(lottos: List<Lotto>) {
        lottos.forEach { lotto ->
            val rank = getRank(lotto.getNumbers())
            statistics.incrementRankCount(rank)
        }
    }

    private fun getRank(lotto: List<Int>): Rank {
        val matchedNumbers = lotto.count { number -> number in winningNumbers }
        val bonusMatch = lotto.contains(bonusNumber)
        val rank = Rank.findByMatch(matchedNumbers, bonusMatch)
        return rank
    }

}
