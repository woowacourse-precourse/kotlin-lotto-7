package lotto.view

import lotto.constants.OutputConstants.COUNT
import lotto.constants.OutputConstants.PERCENT
import lotto.constants.OutputConstants.PROFIT_RATE_MESSAGE
import lotto.constants.OutputConstants.WINNING_RESULT_MESSAGE

class Output {
    fun winningResultMessage(prizeMessages: List<String>) {
        println(WINNING_RESULT_MESSAGE)
        prizeMessages.forEach { println(it + COUNT) }
    }

    fun rateOfReturnMessage(profitRate: Float) {
        println(String.format(PROFIT_RATE_MESSAGE, "$profitRate$PERCENT"))
    }
}
