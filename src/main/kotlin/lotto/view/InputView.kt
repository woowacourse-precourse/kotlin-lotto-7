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

    companion object {
        const val PROMPT_LOTTO_MONEY = "구입금액을 입력해 주세요."
    }
}
