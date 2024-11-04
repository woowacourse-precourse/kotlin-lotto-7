package lotto.view

import lotto.model.Lotto
import lotto.model.Statistics

class OutputView {
    fun printPurchaseHistory(lottoList: List<Lotto>) {
        val sb = StringBuilder()
        sb.appendLine()
        sb.appendLine("${lottoList.size}개를 구매했습니다.")

        lottoList.forEach { lotto ->
            val userLotto = lotto.getNumbers().joinToString(separator = ", ", prefix = "[", postfix = "]")
            sb.appendLine(userLotto)
        }

        println(sb)
    }

    fun printStatistics(statistics: Statistics) {
        println("\n당첨 통계\n---")
        val winningHistory = statistics.getWinningHistory()
        val lottoROI = statistics.getLottoROI()

        println(winningHistory)
        print(lottoROI)
    }
}