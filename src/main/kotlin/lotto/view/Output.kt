package lotto.view

import lotto.constants.Constants.PROFIT_RATE_MSG
import lotto.constants.Constants.WINNING_RESULT_MSG

class Output {
    fun winningResultMsg(prizeMessages: List<String>) {
        println(WINNING_RESULT_MSG)
        prizeMessages.forEach { println(it) }
    }

    fun profitRateMsg(profitRate: Float) {
        println(String.format(PROFIT_RATE_MSG, "$profitRate%"))
    }
}
