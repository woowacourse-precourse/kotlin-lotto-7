package lotto

import camp.nextstep.edu.missionutils.Console

class WinningNumber {
//    init {
//        winningNumberMessege()
//    }

    private var validatorTest = false
    private lateinit var winningNumber: List<String>

    fun winningNumber(): List<Int> {
        while (!validatorTest) {
            winningNumberException()
        }
        return winningNumber.map { it.toInt() }
    }

    private fun winningNumberInput(): List<String> {
        return separateWinningNumber(Console.readLine())
    }

    private fun winningNumberException(): Any {
        try {
            winningNumber = validateWinningNumber(winningNumberInput())
            validatorTest = true
            return winningNumber
        } catch (ex: Exception) {
            return println(ex.message)
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
        require(number.toIntOrNull() != null) { ErrorList.NOT_NUMBERS }
    }

    private fun checkRange(number: String) {
        require(number.toInt() in 0..45) { ErrorList.NOT_LOTTO_NUMBER_RANGE }
    }

    private fun checkSize(userInput: List<String>) {
        require(userInput.size == 6) { ErrorList.NOT_INPUT_SIX_NUMBER }
    }

    private fun checkDuplicates(number: List<String>) {
        require(number.size == number.toSet().size) { ErrorList.DUPLICATED_NUMBERS }
    }

    private fun separateWinningNumber(readLine: String): List<String> {
        return readLine.split(SettingValue.NUMBER_DELIMITER).filter { it.isNotEmpty() }
    }

//    private fun winningNumberMessege() {
//        return println(Message.ENTER_WINNING_NUMBER)
//    }
}