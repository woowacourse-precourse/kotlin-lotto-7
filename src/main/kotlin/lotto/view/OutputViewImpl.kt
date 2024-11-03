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
}