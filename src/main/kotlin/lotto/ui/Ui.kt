package lotto.ui

import camp.nextstep.edu.missionutils.Console
import lotto.domain.exception.ExceptionMessages
import lotto.domain.model.Lotto
import lotto.domain.validation.validateBudget
import lotto.domain.validation.validateWinningNumbers

class Ui {
    fun requestBudget(): Result<Int> = runCatching {
        displayEnterBudgetMessage()
        val userInput = readInt().also { validateBudget(it) }
        return@runCatching userInput
    }

    fun displayExceptionMessage(exception: Throwable) {
        val message = exception.message ?: ExceptionMessages.DEFAULT_EXCEPTION_MESSAGE
        println("$EXCEPTION_MESSAGE_HEADER $message")
    }

    fun displayAmount(amount: Int): Unit = println("${NEW_LINE_FEED}${amount}${AMOUNT_MESSAGE}")

    fun displayLottoes(lottoes: List<Lotto>) {
        val stringBuilder = StringBuilder()

        for (lotto in lottoes) {
            stringBuilder.append(lotto.toString())
            stringBuilder.append(NEW_LINE_FEED)
        }

        println(stringBuilder.toString())
    }

    fun requestWinningNumbers(): Result<List<Int>> = runCatching {
        displayEnterWinningNumbers()
        val userInput = readIntListSplitByComma().also { validateWinningNumbers(it) }
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

    companion object {
        private const val ENTER_BUDGET_MESSAGE = "구입금액을 입력해 주세요."
        private const val EXCEPTION_MESSAGE_HEADER = "[ERROR]"
        private const val AMOUNT_MESSAGE = "개를 구매했습니다."
        private const val NEW_LINE_FEED = '\n'
        private const val ENTER_WINNING_NUMBERS = "당첨 번호를 입력해 주세요."
        private const val WINNING_NUMBER_DELIMITER = ','
    }
}
