package lotto.view

import lotto.model.Lotto
import lotto.model.LottoWinning

class OutputViewImpl : OutputView {

    override fun printNewLine() = println()

    override fun printPurchaseSummary(lottoBundle: List<Lotto>) {
        println("${lottoBundle.size}개를 구매했습니다.")
        for (lotto in lottoBundle) {
            println(lotto.getNumbers().joinToString(", ", "[", "]"))
        }
        printNewLine()
    }

    override fun printWinningStatistics(winningStatistics: Map<LottoWinning, Int>) {
        LottoWinning.entries.reversed().forEach {
            when (it) {
                LottoWinning.NONE -> return
                LottoWinning.SECOND -> println("${it.count}개 일치, 보너스 볼 일치(${it.prize}원) - ${winningStatistics[it]}개")
                else -> println("${it.count}개 일치 (${it.prize}원) - ${winningStatistics[it]}개")
            }
        }
    }

    override fun printProfitRate(profitRate: Double) {
        println("총 수익률은 $profitRate%입니다.")
    }

    companion object {
        private const val PURCHASE_SUMMARY_MESSAGE = "%d개를 구매했습니다."
        private const val WINNING_STATISTICS_MESSAGE = "%d개 일치 (%d원) - %d개"
        private const val WINNING_STATISTICS_WITH_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치(%d원) - %d개"
        private const val PROFIT_RATE_MESSAGE = "총 수익률은 %.2f%%입니다."
    }
}