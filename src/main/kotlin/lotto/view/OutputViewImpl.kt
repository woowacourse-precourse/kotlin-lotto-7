package lotto.view

import lotto.extensions.toFormattedString
import lotto.model.Lotto
import lotto.model.LottoWinning

class OutputViewImpl : OutputView {

    override fun printNewLine() = println()

    override fun printPurchaseSummary(lottoBundle: List<Lotto>) {
        println(PURCHASE_SUMMARY_MESSAGE.format(lottoBundle.size))
        for (lotto in lottoBundle) {
            println(lotto.getNumbers().toFormattedString())
        }
        printNewLine()
    }

    override fun printWinningStatistics(winningStatistics: Map<LottoWinning, Int>) {
        println(WINNING_STATISTICS_HEADER)
        LottoWinning.entries.reversed().forEach {
            when (it) {
                LottoWinning.NONE -> return@forEach
                LottoWinning.SECOND -> println(
                    WINNING_STATISTICS_WITH_BONUS_MESSAGE.format(
                        it.count,
                        it.prize,
                        winningStatistics[it]
                    )
                )

                else -> println(WINNING_STATISTICS_MESSAGE.format(it.count, it.prize, winningStatistics[it]))
            }
        }
    }

    override fun printProfitRate(profitRate: Double) {
        println(PROFIT_RATE_MESSAGE.format(profitRate))
    }

    companion object {
        private const val PURCHASE_SUMMARY_MESSAGE = "%,d개를 구매했습니다."
        private const val WINNING_STATISTICS_HEADER = "당첨 통계\n---"
        private const val WINNING_STATISTICS_MESSAGE = "%d개 일치 (%,d원) - %,d개"
        private const val WINNING_STATISTICS_WITH_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%,d원) - %,d개"
        private const val PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다."
    }
}