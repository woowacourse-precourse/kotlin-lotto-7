package control

import view.ErrorMessage
import view.Input

class WinningNumberValidater {

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

    private fun validateWinningNumber(winningNumber: List<String>): List<String> {
        winningNumber.forEach { number ->
            checkNumber(number)
            checkBigNumber(number)
//            checkIntRange(number)
//            checkRange(number)
        }

        checkSize(winningNumber)
        checkDuplicates(winningNumber)
        return winningNumber
    }

    private fun checkNumber(number: String) {
        require(number.contains(Regex("^[0-9]*$"))) { ErrorMessage.NOT_NUMBERS }
    }

    private fun checkBigNumber(number: String) {
        require(
            number.length < 11
                    && number.toLong() < Int.MAX_VALUE
                    && number.toInt() in 0..45
        ) { ErrorMessage.OUT_OF_LOTTO_NUMBER_RANGE }
    }

    private fun checkSize(winningNumber: List<String>) {
        require(winningNumber.size == 6) { ErrorMessage.NOT_INPUT_SIX_NUMBER }
    }

    private fun checkDuplicates(winningNumber: List<String>) {
        require(winningNumber.size == winningNumber.toSet().size) { ErrorMessage.DUPLICATED_NUMBERS }
    }
}