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
        val price = lottoRank.prize.priceFormat()
        val lottoCount = lottoTicketsRank.count { lottoTicketRank -> lottoTicketRank == lottoRank }
        if (lottoRank == LottoRank.SECOND) {
            return "${matchCount}개 일치, 보너스 볼 일치 (${price}) - ${lottoCount}개"
        }
        return "${matchCount}개 일치 (${price}) - ${lottoCount}개"
    }

    fun outputTotalProfitRate(lottoProfitRate: String) {
        println("총 수익률은 ${lottoProfitRate}입니다.")
    }

    private fun Int.priceFormat(): String {
        val formatter = DecimalFormat(WON_FORMAT_PATTERN)
        return formatter.format(this)
    }

    companion object {
        private const val WINNING_STATISTIC_MESSAGE = "당첨 통계"
        private const val DIVIDER = "---"
        private const val WON_FORMAT_PATTERN = "#,###원"
    }
}