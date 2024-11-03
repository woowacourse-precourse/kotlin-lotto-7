package view

import model.Lotto
import model.Prize
import utils.OutputMessages.BONUS_BALL_MATCH_OUTPUT_MESSAGE
import utils.OutputMessages.BUYING_OUTPUT_MESSAGE
import utils.OutputMessages.COUNT_MATCH_OUTPUT_MESSAGE
import utils.OutputMessages.DASH_OUTPUT_MESSAGE
import utils.OutputMessages.DECIMAL_PATTERN_OUTPUT_MESSAGE
import utils.OutputMessages.EARNING_END_OUTPUT_MESSAGE
import utils.OutputMessages.MONEY_OUTPUT_MESSAGE
import utils.OutputMessages.TOTAL_RETURN_OUTPUT_MESSAGE
import utils.OutputMessages.WINNING_COUNT_OUTPUT_MESSAGE
import utils.OutputMessages.WINNING_STATISTICS_OUTPUT_MESSAGE
import java.text.DecimalFormat
import kotlin.math.round

object OutputView {
    fun printLotto(count: Int, lottoes: List<Lotto>) {
        println(
            count.toString() + BUYING_OUTPUT_MESSAGE
        )
        lottoes.forEach { println(it) }
    }

    fun printWinningStatistics() {
        println(WINNING_STATISTICS_OUTPUT_MESSAGE)
        println(DASH_OUTPUT_MESSAGE)
        Prize.entries.forEach {
            println(
                it.matchCount.toString() + matchOutputMessage(it)
                        + it.prize.toDecimalString() + MONEY_OUTPUT_MESSAGE +
                        it.winningCount.toString() + WINNING_COUNT_OUTPUT_MESSAGE
            )

            // Prize 클래스에 toString 을 정의하는 것도 고민해봤지만, 이 방식이 더 간결해서 else 를 사용했습니다.
            // else 를 사용하지 않고, 간결성을 챙길 수 있다면 편하게 제안해주시면 감사하겠습니다 !
        }
    }

    private fun matchOutputMessage(prize: Prize): String {
        return when (prize) {
            Prize.SECOND -> BONUS_BALL_MATCH_OUTPUT_MESSAGE
            else -> COUNT_MATCH_OUTPUT_MESSAGE

        }
    }

    private fun Int.toDecimalString(): String {
        val decimalFormat = DecimalFormat(DECIMAL_PATTERN_OUTPUT_MESSAGE)
        return decimalFormat.format(this)
    }

    fun printEarningRate(earningRate: Double) {
        val roundRate = round(earningRate * 100) / 100
        println(TOTAL_RETURN_OUTPUT_MESSAGE + roundRate + EARNING_END_OUTPUT_MESSAGE)
    }
}

