package lotto.service

import lotto.view.InputView

class InputService {
    companion object {
        private const val DELIMITER = ","
        private const val ERROR_MESSAGE = "[ERROR]"
        private const val INPUT_EMPTY_STRING = "$ERROR_MESSAGE 빈 문자열은 입력할 수 없습니다."
        private const val INVALID_NUMBER = "$ERROR_MESSAGE 유효하지 않은 입력입니다."

        private val inputView = InputView()

        fun readLineNumberList(): List<Int> {
            val userInput = inputView.readLine()
            require(userInput.isNotBlank()) { INPUT_EMPTY_STRING }

            val numberList = userInput.split(DELIMITER)
                .map { it.trim() }
                .onEach { require(it.isNotEmpty()) { INPUT_EMPTY_STRING } }
                .map { it.toIntOrNull() ?: throw IllegalArgumentException(INVALID_NUMBER) }
            return numberList
        }

        fun readLineNumber(): Int {
            val userInput = inputView.readLine()
            require(userInput.isNotBlank()) { INPUT_EMPTY_STRING }
            return userInput.toIntOrNull() ?: throw IllegalArgumentException(INVALID_NUMBER)
        }
    }

}