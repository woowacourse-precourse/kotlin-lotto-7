package lotto.ui.view

import lotto.common.LottoRank
import java.text.DecimalFormat

class LottoResultView {
    fun outputWinningStatistics(lottoTicketsRank: List<LottoRank>) {
        println(WINNING_STATISTIC_MESSAGE)
        println(DIVIDER)
        LottoRank.getWinningRanks().forEach { lottoRank ->
            println(formatLottoRankResult(lottoRank, lottoTicketsRank))
        }
    }

    private fun formatLottoRankResult(lottoRank: LottoRank, lottoTicketsRank: List<LottoRank>): String {
        val matchCount = lottoRank.matchCount
        val price = lottoRank.prize.toWonFormat()
        val lottoCount = lottoTicketsRank.count { lottoTicketRank -> lottoTicketRank == lottoRank }
        if (lottoRank == LottoRank.SECOND) {
            return String.format(BONUS_MATCH_MESSAGE, matchCount, price, lottoCount)
        }
        return String.format(MATCH_MESSAGE, matchCount, price, lottoCount)
    }

    fun outputTotalProfitRate(lottoProfitRate: String) {
        println("$TOTAL_PROFIT_RATE_MASSAGE$lottoProfitRate$TOTAL_PROFIT_ENDING_MESSAGE")
    }

    private fun Int.toWonFormat(): String {
        val formatter = DecimalFormat(WON_FORMAT_PATTERN)
        return formatter.format(this)
    }

    companion object {
        private const val WINNING_STATISTIC_MESSAGE = "당첨 통계"
        private const val DIVIDER = "---"
        private const val WON_FORMAT_PATTERN = "#,###원"
        private const val TOTAL_PROFIT_RATE_MASSAGE = "총 수익률은 "
        private const val TOTAL_PROFIT_ENDING_MESSAGE = "입니다."
        private const val BONUS_MATCH_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s) - %d개"
        private const val MATCH_MESSAGE = "%d개 일치 (%s) - %d개"
    }
}