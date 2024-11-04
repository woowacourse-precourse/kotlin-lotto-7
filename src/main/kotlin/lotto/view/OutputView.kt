package lotto.view

import lotto.constants.LottoMessages.BONUS_INFO
import lotto.constants.LottoMessages.MESSAGE_LOTTO_COUNT_PURCHASED
import lotto.constants.LottoMessages.MESSAGE_LOTTO_YIELD
import lotto.constants.LottoMessages.MESSAGE_WINNING_STATISTICS
import lotto.constants.LottoMessages.MESSAGE_WINNING_STATISTICS_TITLE
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
        private val THOUSAND_COMMA = DecimalFormat("#,###")
    }
}

