package lotto.domain.winning

import lotto.domain.lotto.BonusNumber
import lotto.domain.lotto.Lotto
import lotto.domain.lotto.LottoTicket
import lotto.domain.purchase.Purchase
import lotto.domain.rank.LottoRank

private const val PERCENTAGE = 100

class WinningManager(
    private val purchase: Purchase,
    private val lottoTicket: LottoTicket,
    private val winningNumber: Lotto,
    private val bonusNumber: BonusNumber,
) {
    private val winningStatistics = WinningStatistics()

    fun getWinningStatistics(): WinningStatistics {
        val matchedInfos = lottoTicket.compareWinningLotto(winningNumber, bonusNumber)
        matchedInfos.forEach {
            val lottoRank = LottoRank.getRank(it)
            winningStatistics.update(lottoRank)
        }
        return winningStatistics
    }

    fun getProfitRate(): Double {
        val profit = winningStatistics.calculateProfit()
        val purchaseAmount = purchase.getAmount().toDouble()
        val profitRate = (profit / purchaseAmount) * PERCENTAGE
        return profitRate
    }

}