package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.InputParser.parseNumericInput
import lotto.util.InputParser.parseWinningNumbers
import lotto.util.InputValidator.validateMoneyIsNotNegative
import lotto.util.InputValidator.validateMoneyIsEnough
import lotto.util.InputValidator.validateMoneyIsDivisible
import lotto.util.InputValidator.validateWinningNumbersCount
import lotto.util.InputValidator.validateWinningNumbersDistinctness

class InputView {
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
        val numbers = parseWinningNumbers(Console.readLine())
        validateWinningNumbersCount(numbers)
        validateWinningNumbersDistinctness(numbers)
        return numbers
    }

    companion object {
        const val PROMPT_LOTTO_MONEY = "구입금액을 입력해 주세요."
        const val PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요."
    }
}
