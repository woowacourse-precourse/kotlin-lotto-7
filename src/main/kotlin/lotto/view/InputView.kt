package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.ErrorMessage
import lotto.util.InputValidator.validateMoneyIsNotNegative
import lotto.util.InputValidator.validateMoneyIsEnough
import lotto.util.InputValidator.validateMoneyIsDivisible

class InputView {
    private fun parseNumericInput(input: String): Int {
        if (input.toIntOrNull() == null) throw IllegalArgumentException(ErrorMessage.INPUT_NOT_NUMERIC)
        return input.toInt()
    }

    fun readLottoMoney(): Int {
        println(PROMPT_LOTTO_MONEY)
        val money = parseNumericInput(Console.readLine())
        validateMoneyIsNotNegative(money)
        validateMoneyIsEnough(money)
        validateMoneyIsDivisible(money)
        return money
    }

    fun readWinningNumbers(): List<Int> {
        println(PROMPT_WINNING_NUMBERS)
        val numbers = Console.readLine().split(WINNING_NUMBERS_DELIMITER).map { it.toInt() }
        return numbers
    }

    companion object {
        const val PROMPT_LOTTO_MONEY = "구입금액을 입력해 주세요."
        const val PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요."
        const val WINNING_NUMBERS_DELIMITER = ","
    }
}
