package lotto.ui.console

import camp.nextstep.edu.missionutils.Console
import lotto.domain.exception.ExceptionMessages
import lotto.domain.validation.validateBonusWinningNumber
import lotto.domain.validation.validateBudget
import lotto.domain.validation.validateWinningNumbers
import lotto.ui.InputView

class ConsoleInputView : InputView {
    override fun requestBudget(): Result<Int> = runCatching {
        displayEnterBudgetMessage()
        val userInput = readInt().also { validateBudget(it) }
        return@runCatching userInput
    }

    override fun requestWinningNumbers(): Result<List<Int>> = runCatching {
        displayEnterWinningNumbers()
        val userInput = readIntListSplitByComma().also { validateWinningNumbers(it) }
        return@runCatching userInput
    }

    override fun requestBonusWinningNumber(winningNumbers: List<Int>): Result<Int> = runCatching {
        displayEnterBonusWinningNumber()
        val userInput = readInt().also { validateBonusWinningNumber(it, winningNumbers) }
        return@runCatching userInput
    }

    private fun displayEnterBudgetMessage(): Unit = println(ENTER_BUDGET_MESSAGE)

    private fun readInt(): Int = runCatching {
        Console.readLine().toInt()
    }.getOrElse {
        if (it is NumberFormatException) throw NumberFormatException(ExceptionMessages.INVALID_NUMBER_FORMAT)
        throw it
    }

    private fun displayEnterWinningNumbers(): Unit = println(ENTER_WINNING_NUMBERS)

    private fun readIntListSplitByComma(): List<Int> = runCatching {
        Console.readLine().split(WINNING_NUMBER_DELIMITER).map(String::toInt)
    }.getOrElse {
        if (it is NumberFormatException) throw NumberFormatException(ExceptionMessages.INVALID_NUMBER_FORMAT)
        throw it
    }

    private fun displayEnterBonusWinningNumber(): Unit = println("$NEW_LINE_FEED$ENTER_BONUS_WINNING_NUMBER")

    companion object {
        private const val ENTER_BUDGET_MESSAGE = "구입금액을 입력해 주세요."
        private const val ENTER_WINNING_NUMBERS = "당첨 번호를 입력해 주세요."
        private const val WINNING_NUMBER_DELIMITER = ','
        private const val ENTER_BONUS_WINNING_NUMBER = "보너스 번호를 입력해 주세요."
        private const val NEW_LINE_FEED = '\n'
    }
}
