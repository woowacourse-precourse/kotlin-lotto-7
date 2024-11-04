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

            when (matchCount) {
                Rank.FIRST.matchCount -> lottoStats.add(Rank.FIRST)
                Rank.SECOND.matchCount -> lottoStats.add(checkBonusNumber(userLotto, bonusNumber))
                Rank.THIRD.matchCount -> lottoStats.add(checkBonusNumber(userLotto, bonusNumber))
                Rank.FOURTH.matchCount -> lottoStats.add(Rank.FOURTH)
                Rank.FIFTH.matchCount -> lottoStats.add(Rank.FIFTH)
            }
        }
    }

    fun checkBonusNumber(userLotto: List<Int>, bonusNumber: Int): Rank {
        if (userLotto.contains(bonusNumber)) return Rank.SECOND
        return Rank.THIRD
    }

    fun getLottoStats() = lottoStats
}