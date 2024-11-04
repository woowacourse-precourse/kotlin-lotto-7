package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.constant.InputConst

class InputView {

    private fun getInput(message: String): String {
        println(message)
        val input = Console.readLine()
        return input
    }

    fun close() = Console.close()

    fun getPurchaseAmount(): String = getInput(InputConst.PURCHASE_AMOUNT_INPUT)
    fun getWinningNumber(): String = getInput(InputConst.WINNING_NUMBER_INPUT)
    fun getBonusNumber(): String = getInput(InputConst.BONUS_NUMBER_INPUT)
}