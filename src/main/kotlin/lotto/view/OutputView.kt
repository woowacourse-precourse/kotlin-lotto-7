package lotto.view

import lotto.model.LottoPrize
import lotto.model.LottoPrize.SECOND_PRIZE
import java.text.DecimalFormat

class OutputView {

    fun printLottosCount(lottosCount: Int) {
        println()
        println(MESSAGE_LOTTO_COUNT_PURCHASED.format(lottosCount))
    }

    fun printWinningStatisticsTitle() {
        println()
        println(MESSAGE_WINNING_STATISTICS_TITLE)
    }

    fun printWinningStatistics(prize: LottoPrize, count: Int) {
        val bonusInfo = BONUS_INFO.takeIf { prize == SECOND_PRIZE } ?: ""
        val formattedPrice = THOUSAND_COMMA.format(prize.price)

        println(MESSAGE_WINNING_STATISTICS.format(prize.matchingCount, bonusInfo, formattedPrice, count))
    }

    fun printLottoYield(yield: Double) {
        val formattedYield = String.format("%.1f", yield)
        println(MESSAGE_LOTTO_YIELD.format(formattedYield))
    }

    companion object {
        private const val MESSAGE_LOTTO_COUNT_PURCHASED = "%d개를 구매했습니다."
        private const val MESSAGE_WINNING_STATISTICS_TITLE = "당첨 통계\n---"
        private const val MESSAGE_WINNING_STATISTICS = "%d개 일치%s (%s원) - %d개"
        private const val MESSAGE_LOTTO_YIELD = "총 수익률은 %s%%입니다."
        private const val BONUS_INFO = ", 보너스 볼 일치"

        private val THOUSAND_COMMA = DecimalFormat("#,###")
    }
}

