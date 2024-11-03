package lotto.ui

import java.text.DecimalFormat

object OutputView {

    private const val OTHER_ERROR_MESSAGE = "[ERROR] 다시 입력해주세요."
    private const val LOTTO_QUANTITY_MESSAGE = "%d개를 구매했습니다."
    private const val WINNING_DETAIL_HEAD_MESSAGE = "당첨 통계\n---"
    private const val WINNING_DETAIL_MATCHES_NUMBER_MESSAGE = "%d개 일치"
    private const val WINNING_DETAIL_BONUS_MATCH_MESSAGE = ", 보너스 볼 일치"
    private const val WINNING_DETAIL_PRIZE_FORMAT = " (#,###원)"
    private const val WINNING_DETAIL_DIVIDER = " - "
    private const val WINNING_DETAIL_COUNT_FORMAT = "#,###개"
    private const val WINNING_PROFIT_RATE_FORMAT = "총 수익률은 %s입니다."

    fun printErrorCauseMessage(message: String) = println(message)

    fun printOtherErrorMessage() = println(OTHER_ERROR_MESSAGE)

    fun printNewLine() = println()

    fun printLottoQuantity(quantity: Int) = println(LOTTO_QUANTITY_MESSAGE.format(quantity))

    fun printLottoNumber(number: List<Int>) = println(number)

    fun printWinningDetailHead() = println(WINNING_DETAIL_HEAD_MESSAGE)

    fun printMatchesNumbers(count: Int) = print(WINNING_DETAIL_MATCHES_NUMBER_MESSAGE.format(count))

    fun printWinningBonusMatch() = print(WINNING_DETAIL_BONUS_MATCH_MESSAGE)

    fun printWinningPrize(prize: Int) {
        val decimalFormat = DecimalFormat(WINNING_DETAIL_PRIZE_FORMAT)
        print(decimalFormat.format(prize))
    }

    fun printWinningDivider() = print(WINNING_DETAIL_DIVIDER)

    fun printWinningCount(count: Int) {
        val decimalFormat = DecimalFormat(WINNING_DETAIL_COUNT_FORMAT)
        println(decimalFormat.format(count))
    }

    fun printProfitRate(profitRate: Double) {
        print(WINNING_PROFIT_RATE_FORMAT.format(String.format("%,.1f%%", profitRate)))
    }
}