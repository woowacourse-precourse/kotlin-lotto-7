package lotto.view

import lotto.constants.OutputConstants.COUNT
import lotto.constants.OutputConstants.PERCENT
import lotto.constants.OutputConstants.PROFIT_RATE_MSG
import lotto.constants.OutputConstants.WINNING_RESULT_MSG

class Output {
    fun winningResultMsg(prizeMessages: List<String>) {
        println(WINNING_RESULT_MSG)
        prizeMessages.forEach { println(it + COUNT) }
    }

    fun profitRateMsg(profitRate: Float) {
        println(String.format(PROFIT_RATE_MSG, "$profitRate$PERCENT"))
    }
}
