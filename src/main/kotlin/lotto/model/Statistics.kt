package lotto.model

import java.text.DecimalFormat

data class Statistics(private val winningHistory: Map<Rank, Int>, private val lottoROI: Double) {
    fun getWinningHistory(): String {
        val sb = StringBuilder()

        winningHistory.forEach { (rank, matchCount) ->
            val formatType = when(rank) {
                Rank.SECOND -> BONUS_WINNING_FORMAT
                else -> WINNING_FORMAT
            }
            val prize = decimalFormat.format(rank.prize)
            val eachWinning = String.format(format = formatType, rank.matchCount, prize, matchCount)

            sb.appendLine(eachWinning)
        }

        return sb.toString().trim()
    }

    fun getLottoROI() = String.format(ROI_FORMAT, lottoROI)

    companion object {
        val decimalFormat = DecimalFormat("#,###")
        private const val WINNING_FORMAT = "%d개 일치 (%s원) - %d개"
        private const val BONUS_WINNING_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개"

        private const val ROI_FORMAT = "총 수익률은 %.1f%%입니다."
    }
}
