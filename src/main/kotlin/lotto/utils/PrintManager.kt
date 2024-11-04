package lotto.utils

import lotto.Lotto
import lotto.WinningRank

object PrintManager {

    private const val CREATED_LOTTO_SUFFIX = "개를 구매했습니다."
    fun printCreatedLotto(lottoSet: List<Lotto>) {
        val lottoCount = lottoSet.size
        println("\n$lottoCount$CREATED_LOTTO_SUFFIX")
        printLottoSet(lottoSet)
        println()
    }

    private fun printLottoSet(lottoSet: List<Lotto>) {
        lottoSet.forEach {
            println(it.numbers)
        }
    }

    private const val WINNING_STATISTICS_TITLE = "\n당첨 통계\n---"
    fun printWinningStatistics(
        winningRankSet: List<WinningRank>,
        earningsRate: String,
    ) {
        println(WINNING_STATISTICS_TITLE)
        printWinningRankSet(winningRankSet)
        printEarningsRate(earningsRate)
    }

    private fun printWinningRankSet(winningRankSet:List<WinningRank>) {
        WinningRank.entries.forEach { rank ->
            val winningCount = winningRankSet.count {
                rank == it
            }
            printWinningRank(rank, winningCount)
        }
    }

    private fun printWinningRank(winningRank: WinningRank, count: Int) {
        if(winningRank != WinningRank.PLACE_Fail) {
            println(winningRank.str() + " - ${count}개")
        }
    }

    private fun printEarningsRate(earningsRate: String) {
        println("총 수익률은 ${earningsRate}%입니다.")
    }

}