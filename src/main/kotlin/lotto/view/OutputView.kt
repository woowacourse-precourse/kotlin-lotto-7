package lotto.view

import lotto.model.Lotto
import lotto.model.Statistics

class OutputView {
    fun printPurchaseHistory(lottoList: List<Lotto>) {
        val sb = StringBuilder()
        sb.appendLine()
        sb.appendLine(String.format(PURCHASE_HISTORY_FORMAT, lottoList.size))

        lottoList.forEach { lotto ->
            val userLotto = lotto.getNumbers().joinToString(separator = SEPARATOR, prefix = PREFIX, postfix = POSTFIX)
            sb.appendLine(userLotto)
        }

        println(sb)
    }

    fun printStatistics(statistics: Statistics) {
        println(STATISTICS_MSG)
        val winningHistory = statistics.getWinningHistory()
        val lottoROI = statistics.getLottoROI()

        println(winningHistory)
        print(lottoROI)
    }

    companion object {
        private const val PURCHASE_HISTORY_FORMAT = "%d개를 구매했습니다."
        private const val STATISTICS_MSG = "\n당첨 통계\n---"

        private const val SEPARATOR = ","
        private const val PREFIX = "["
        private const val POSTFIX = "]"

    }
}