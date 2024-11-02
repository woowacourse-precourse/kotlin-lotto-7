package lotto.view

import lotto.util.OutputMessages
import lotto.util.PrizeRank
import java.text.DecimalFormat

class OutputView {
    fun printRequirePaymentMessage() {
        println(OutputMessages.MESSAGE_INPUT_PAYMENT.message)
    }

    fun printAmountTickets(tickets: Int) {
        println()
        print(DecimalFormat(OutputMessages.NUMBER_FORMAT.message).format(tickets))
        println(OutputMessages.PRINT_AMOUNT_TICKETS.message)
    }

    fun printInformationLotto(lotto: List<List<Int>>) {
        println(lotto.joinToString(OutputMessages.NEW_LINE.message))
    }

    fun printRequirePrizeNumber() {
        println()
        println(OutputMessages.MESSAGE_PRIZE_NUMBER.message)
    }

    fun printRequireBonusNumber() {
        println()
        println(OutputMessages.MESSAGE_BONUS_NUMBER.message)
    }

    fun printResult(prizeResult: MutableMap<PrizeRank, Int>, earningRate: Double) {
        val sb = StringBuilder(OutputMessages.MESSAGE_RESULT.message)
        eachRankMessages.forEach { (rank, output) ->
            sb.append(output.message)
            sb.append(DecimalFormat(OutputMessages.NUMBER_FORMAT.message).format(prizeResult[rank]))
            sb.append(OutputMessages.UNIT_CORRECT.message)
        }
        sb.append(OutputMessages.RESULT.message)
        sb.append(DecimalFormat(OutputMessages.RATE_FORMAT.message).format(earningRate))
        sb.append(OutputMessages.RESULT_SECOND.message)
        println(sb)
    }

    companion object {
        private val eachRankMessages = listOf(
            PrizeRank.FIFTH to OutputMessages.PRINT_RESULT_THREE,
            PrizeRank.FOURTH to OutputMessages.PRINT_RESULT_FOUR,
            PrizeRank.THIRD to OutputMessages.PRINT_RESULT_FIVE,
            PrizeRank.SECOND to OutputMessages.PRINT_RESULT_FIVE_WITH_BONUS,
            PrizeRank.FIRST to OutputMessages.PRINT_RESULT_ALL
        )
    }
}