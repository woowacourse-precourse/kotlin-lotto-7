package lotto.ui

import camp.nextstep.edu.missionutils.Console
import lotto.domain.exception.ExceptionMessages
import lotto.domain.validation.validateBudget

class Ui {
    fun requestBudget(): Result<Int> = runCatching {
        displayEnterBudgetMessage()
        val userInput = readInt().also { validateBudget(it) }
        return@runCatching userInput
    }

    fun displayExceptionMessage(message: String?): Unit =
        System.err.println("$EXCEPTION_MESSAGE_HEADER ${message ?: ExceptionMessages.DEFAULT_EXCEPTION_MESSAGE}")

    private fun displayEnterBudgetMessage(): Unit = println(ENTER_BUDGET_MESSAGE)

    private fun readInt(): Int = runCatching {
        Console.readLine().toInt()
    }.getOrElse {
        if (it is NumberFormatException) throw NumberFormatException(ExceptionMessages.INVALID_NUMBER_FORMAT)
        throw it
    }

    companion object {
        private const val ENTER_BUDGET_MESSAGE = "구입금액을 입력해 주세요."
        private const val EXCEPTION_MESSAGE_HEADER = "[ERROR]"
    }
}
