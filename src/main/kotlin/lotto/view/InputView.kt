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

    private fun <T> loopUntilValid(action: () -> T): T {
        while (true) {
            try { return action() }
            catch (e: IllegalArgumentException) { println("\n${e.message}\n") }
        }
    }

    fun readLottoMoney(): Int {
        return loopUntilValid {
            println(PROMPT_LOTTO_MONEY)

            val money = parseNumericInput(Console.readLine())
            validateMoneyIsNotNegative(money)
            validateMoneyIsEnough(money)
            validateMoneyIsDivisible(money)

            println()
            money
        }
    }

    fun readWinningNumbers(): List<Int> {
        return loopUntilValid {
            println(PROMPT_WINNING_NUMBERS)

            winningNumbers.clear()
            winningNumbers.addAll(parseWinningNumbers(Console.readLine()))
            validateWinningNumbersCount(winningNumbers)
            validateWinningNumbersDistinctness(winningNumbers)
            winningNumbers.forEach { validateLottoNumberInRange(it) }

            println()
            winningNumbers
        }
    }

    fun readBonusNumber(): Int {
        return loopUntilValid {
            println(PROMPT_BONUS_NUMBER)

            val bonusNumber = parseNumericInput(Console.readLine())
            validateLottoNumberInRange(bonusNumber)
            validateBonusNumberDistinctness(bonusNumber, winningNumbers)

            println()
            bonusNumber
        }
    }

    companion object {
        const val PROMPT_LOTTO_MONEY = "구입금액을 입력해 주세요."
        const val PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요."
        const val PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."
    }
}
