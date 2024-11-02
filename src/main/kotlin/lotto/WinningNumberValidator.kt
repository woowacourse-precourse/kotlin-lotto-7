package lotto

import view.ErrorMessage
import view.Input

class WinningNumberValidator {

    private var validatorTest = false
    private lateinit var winningNumber: List<String>

    fun validate(): List<Int> {
        while (!validatorTest) {
            winningNumberException()
        }
        return winningNumber.map { it.toInt() }
    }

    private fun winningNumberException(): Any {
        try {
            winningNumber = validateWinningNumber(Input().winningNumberInput())
            validatorTest = true
            return winningNumber
        } catch (ex: Exception) {
            return print(ex.message)
        }
    }

    private fun validateWinningNumber(userInput: List<String>): List<String> {

        userInput.forEach { number ->
            checkInt(number)
            checkRange(number)
        }
        checkSize(userInput)
        checkDuplicates(userInput)
        return userInput
    }

    private fun checkInt(number: String) {
        require(number.toIntOrNull() != null) { ErrorMessage.NOT_NUMBERS }
    }

    private fun checkRange(number: String) {
        require(number.toInt() in 0..45) { ErrorMessage.NOT_LOTTO_NUMBER_RANGE }
    }

    private fun checkSize(userInput: List<String>) {
        require(userInput.size == 6) { ErrorMessage.NOT_INPUT_SIX_NUMBER }
    }

    private fun checkDuplicates(number: List<String>) {
        require(number.size == number.toSet().size) { ErrorMessage.DUPLICATED_NUMBERS }
    }
}