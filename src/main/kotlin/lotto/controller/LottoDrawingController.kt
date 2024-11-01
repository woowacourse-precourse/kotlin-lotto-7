package lotto.controller

import lotto.model.LottoMatchRank
import lotto.model.LottoTicket
import lotto.model.WinningStatistics

class LottoDrawingController(
    private val lottoTicket: LottoTicket,
    private val winningNumbers: List<Int?>,
    private val bonusNumber: Int,
    private val winningStatistics: WinningStatistics
) {

    fun calculateMatchCount() {
        for (index in 0 until lottoTicket.numberOfPurchase) {
            val lotto = lottoTicket.userLottoNumbers[index]
            val matchCount = lotto.getNumbers().intersect(winningNumbers.toSet()).size
            val hasBonus = lotto.getNumbers().contains(bonusNumber)

            val rank = determineRank(matchCount, hasBonus)
            rank?.ordinal?.let { ordinalIndex ->
                winningStatistics.addMatchCountStatistics(ordinalIndex)
            }
        }
    }

    fun calculateTotalPrize() {
        for (index in 0 until winningStatistics.matchCountStatistics.size) {
            val count = winningStatistics.matchCountStatistics[index]
            val prize = getPrizeByRankIndex(index)

            winningStatistics.addTotalPrize(count * prize)
        }
    }

    private fun determineRank(matchCount: Int, hasBonus: Boolean): LottoMatchRank? {
        return when {
            matchCount == LottoMatchRank.FIFTH.matchCount -> LottoMatchRank.FIFTH
            matchCount == LottoMatchRank.FOURTH.matchCount -> LottoMatchRank.FOURTH
            matchCount == LottoMatchRank.THIRD.matchCount && !hasBonus -> LottoMatchRank.THIRD
            matchCount == LottoMatchRank.SECOND.matchCount && hasBonus -> LottoMatchRank.SECOND
            matchCount == LottoMatchRank.FIRST.matchCount -> LottoMatchRank.FIRST
            else -> null
        }
    }

    private fun getPrizeByRankIndex(index: Int): Int {
        return when (index) {
            0 -> LottoMatchRank.FIFTH.prize
            1 -> LottoMatchRank.FOURTH.prize
            2 -> LottoMatchRank.THIRD.prize
            3 -> LottoMatchRank.SECOND.prize
            4 -> LottoMatchRank.FIRST.prize
            else -> 0
        }
    }

}