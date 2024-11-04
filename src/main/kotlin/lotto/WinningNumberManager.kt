package lotto

import camp.nextstep.edu.missionutils.Console

class WinningNumberManager {

    var winningNumbers: List<Int> = listOf()

    fun requestWinningNumbers() {
        println(REQUEST_WINNING_NUMBERS_MESSAGE)
        val winningNumbersInput = Console.readLine()
        try {
            validateWinningNumbersInput(winningNumbersInput)
            println()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            println()
            requestWinningNumbers()
        }
    }

    private fun validateWinningNumbersInput(winningNumbersInput: String) {
        if (!winningNumbersInput.matches(Regex(REGEX_WINNING_NUMBERS_PATTERN))) {
            throw IllegalArgumentException(ERROR_WINNING_NUMBERS_INPUT_MESSAGE)
        }

        val rawWinningNumbers = winningNumbersInput.split(WINNING_NUMBER_SPLITTER)
        if (rawWinningNumbers.any { it.isBlank() }) {
            throw IllegalArgumentException(ERROR_WINNING_NUMBERS_BLANK_MESSAGE)
        }

        val lotto = Lotto(rawWinningNumbers.map(String::toInt))
        winningNumbers = lotto.getNumbers()
    }

    companion object {
        private const val WINNING_NUMBER_SPLITTER = ','
        private const val REQUEST_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요."
        private const val REGEX_WINNING_NUMBERS_PATTERN = "^[0-9,]+\$"
        private const val ERROR_WINNING_NUMBERS_INPUT_MESSAGE = "[ERROR] 당첨 번호 입력은 부호가 없는 숫자와 쉼표(,)만 입력 가능합니다."
        private const val ERROR_WINNING_NUMBERS_BLANK_MESSAGE = "[ERROR] 당첨 번호는 빈 값이 올 수 없습니다."
    }
}