package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.InputParser.parseNumericInput
import lotto.util.InputParser.parseWinningNumbers
import lotto.util.InputValidator.validateBonusNumberDistinctness
import lotto.util.InputValidator.validateLottoNumberInRange
import lotto.util.InputValidator.validateMoneyIsNotNegative
import lotto.util.InputValidator.validateMoneyIsEnough
import lotto.util.InputValidator.validateMoneyIsDivisible
import lotto.util.InputValidator.validateWinningNumbersCount
import lotto.util.InputValidator.validateWinningNumbersDistinctness

class InputView {
    private val winningNumbers = mutableListOf<Int>()

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
        winningNumbers.addAll(parseWinningNumbers(Console.readLine()))
        validateWinningNumbersCount(winningNumbers)
        validateWinningNumbersDistinctness(winningNumbers)
        winningNumbers.forEach { validateLottoNumberInRange(it) }
        return winningNumbers
    }

    fun readBonusNumber(): Int {
        println(PROMPT_BONUS_NUMBER)
        val bonusNumber = parseNumericInput(Console.readLine())
        validateLottoNumberInRange(bonusNumber)
        validateBonusNumberDistinctness(bonusNumber, winningNumbers)
        return bonusNumber
    }

    companion object {
        const val PROMPT_LOTTO_MONEY = "구입금액을 입력해 주세요."
        const val PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요."
        const val PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."
    }
}
