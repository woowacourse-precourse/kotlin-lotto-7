package lotto.controller

import lotto.model.LottoMatchRank
import lotto.model.LottoTicket
import lotto.model.WinningStatistics
import kotlin.math.round

class LottoDrawingController(
    private val lottoTicket: LottoTicket,
    private val winningNumbers: List<Int?>,
    private val bonusNumber: Int,
    private val winningStatistics: WinningStatistics
) {

    fun calculateMatchCount() {
        lottoTicket.userLottoNumbers.forEachIndexed { _, lotto ->
            val matchCount = lotto.getNumbers().intersect(winningNumbers.toSet()).size
            val hasBonus = lotto.getNumbers().contains(bonusNumber)

            val rank = determineRank(matchCount, hasBonus)
            rank?.ordinal?.let {
                winningStatistics.addMatchCountStatistics(it)
            }
        }
    }

    fun calculateTotalPrize() {
        winningStatistics.matchCountStatistics.forEachIndexed { index, count ->
            val prize = LottoMatchRank.entries.getOrNull(index)?.prize ?: 0
            winningStatistics.addTotalPrize(count * prize)
        }
    }

    fun calculateReturnRate(purchaseAmount: Int): Double {
        val returnRate = winningStatistics.totalPrize.toDouble() / purchaseAmount * 100
        return round(returnRate * 10) / 10
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

}