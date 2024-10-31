package lotto.view

import lotto.util.OutputMessages
import lotto.util.PrizeRank

class OutputView {
    fun printRequirePaymentMessage() {
        println(OutputMessages.MESSAGE_INPUT_PAYMENT.message)
    }

    fun printAmountTickets(tickets: Int) {
        println()
        println("$tickets${OutputMessages.PRINT_AMOUNT_TICKETS.message}")
    }

    fun printInformationLotto(lotto: List<List<Int>>) {
        println(lotto.joinToString(OutputMessages.LINE_FEED.message))
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
        sb.append("${OutputMessages.PRINT_RESULT_THREE.message}${prizeResult[PrizeRank.FIFTH]}")
        sb.append(OutputMessages.UNIT_CORRECT.message)
        sb.append("${OutputMessages.PRINT_RESULT_FOUR.message}${prizeResult[PrizeRank.FOURTH]}")
        sb.append(OutputMessages.UNIT_CORRECT.message)
        sb.append("${OutputMessages.PRINT_RESULT_FIVE.message}${prizeResult[PrizeRank.THIRD]}")
        sb.append(OutputMessages.UNIT_CORRECT.message)
        sb.append("${OutputMessages.PRINT_RESULT_FIVE_WITH_BONUS.message}${prizeResult[PrizeRank.SECOND]}")
        sb.append(OutputMessages.UNIT_CORRECT.message)
        sb.append("${OutputMessages.PRINT_RESULT_ALL.message}${prizeResult[PrizeRank.FIRST]}")
        sb.append(OutputMessages.UNIT_CORRECT.message)
        sb.append("${OutputMessages.RESULT.message}$earningRate${OutputMessages.RESULT_SECOND.message}")
        println(sb)
    }
}