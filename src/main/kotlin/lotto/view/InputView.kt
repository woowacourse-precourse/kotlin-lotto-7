package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto

class InputView {
    fun readPurchaseAmount(): Int {
        println(USER_INPUT_MONEY)
        val input = Console.readLine()
        validateNumber(input)
        return input.toInt()
    }

    fun readWinningNumbers(): List<Int> {
        println(USER_INPUT_WINNING_NUMBERS)
        val input = Console.readLine()
        return parseNumbers(input)
    }

    fun readBonusNumber(): Int {
        println(USER_INPUT_BONUS_NUMBER)
        val input = Console.readLine()
        validateNumber(input)
        return input.toInt()
    }

    private fun validateNumber(input: String) {
        require(input.matches(Regex("\\d+"))) { sendError(LOTTO_NUMBER_TYPE_ERROR) }
    }

    private fun parseNumbers(input: String): List<Int> =
        input
            .split(",")
            .map { it.trim() }
            .also { numbers ->
                require(numbers.size == Lotto.LOTTO_SIZE) { sendError(LOTTO_NUMBER_COUNT_ERROR) }
            }.map { number ->
                validateNumber(number)
                number.toInt()
            }

    companion object {
        private const val ERROR_PREFIX = "[ERROR] "
        const val USER_INPUT_MONEY = "구입금액을 입력해 주세요."
        const val USER_INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요."
        const val USER_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."

        const val LOTTO_NUMBER_COUNT_ERROR = "로또 번호는 6개여야 합니다."
        const val LOTTO_NUMBER_TYPE_ERROR = "숫자만 입력 가능합니다."

        fun sendError(message: String): String = ERROR_PREFIX + message
    }
}
