package lotto.calculator

import lotto.enums.Rank

class LottoStatsCalculator(
    private val lottoTickets: List<List<Int>>,
    private val winningNumber: List<Int>,
    private val bonusNumber: Int
) {

    private val lottoStats = mutableListOf<Rank>()

    init {
        calculateRank()
    }

    private fun calculateRank() {
        lottoTickets.forEach { userLotto ->
            val matchCount: Int = userLotto.intersect(winningNumber).size
            val rank = when (matchCount) {
                Rank.FIRST.matchCount -> Rank.FIRST
                Rank.SECOND.matchCount, Rank.THIRD.matchCount -> checkBonusNumber(userLotto, bonusNumber)
                Rank.FOURTH.matchCount -> Rank.FOURTH
                Rank.FIFTH.matchCount -> Rank.FIFTH
                else -> null // 해당하는 랭크가 없는 경우
            }

            rank?.let { lottoStats.add(it) }
        }
    }

    fun checkBonusNumber(userLotto: List<Int>, bonusNumber: Int): Rank {
        if (userLotto.contains(bonusNumber)) return Rank.SECOND
        return Rank.THIRD
    }

    fun getLottoStats() = lottoStats
}