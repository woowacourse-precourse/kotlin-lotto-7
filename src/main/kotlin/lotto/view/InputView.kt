package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.InputValidator.validateInputIsNumeric
import lotto.util.InputValidator.validateMoneyIsNotNegative
import lotto.util.InputValidator.validateMoneyIsEnough
import lotto.util.InputValidator.validateMoneyIsDivisible

class InputView {
    fun readLottoMoney(): Int {
        println(PROMPT_LOTTO_MONEY)
        val input = Console.readLine()
        validateInputIsNumeric(input)
        val money = input.toInt()
        validateMoneyIsNotNegative(money)
        validateMoneyIsEnough(money)
        validateMoneyIsDivisible(money)
        return money
    }

    companion object {
        const val PROMPT_LOTTO_MONEY = "구입금액을 입력해 주세요."
    }
}
