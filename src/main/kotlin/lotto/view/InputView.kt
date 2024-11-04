package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.constants.Constants.PRICE_INPUT_MSG
import lotto.constants.Constants.WINNING_NUMBERS_INPUT_MSG
import lotto.constants.Constants.BONUS_NUMBER_INPUT_MSG

class InputView {
    fun getPriceInput(): String {
        println(PRICE_INPUT_MSG)
        return read()
    }

    fun getWinningNumbersInput(): String {
        println(WINNING_NUMBERS_INPUT_MSG)
        return read()
    }

    fun getBonusNumberInput(): String {
        println(BONUS_NUMBER_INPUT_MSG)
        return read()
    }

    private fun read(): String = Console.readLine() ?: throw IllegalArgumentException()

    fun close() = Console.close()
}