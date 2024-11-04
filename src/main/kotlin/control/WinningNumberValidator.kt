package control

import util.SettingValue
import util.ErrorMessage
import view.Input

class WinningNumberValidator {

    private var validatorTest = false
    private lateinit var winningNumber: List<String>

    // Stack Overflow 방지 위해 while 구현
    fun validate(): List<Int> {
        while (!validatorTest) {
            winningNumber = Input().winningNumberInput()
            checkException()
        }
        return winningNumber.map { it.toInt() }
    }

    private fun checkException() {
        try {
            check(winningNumber)
            validatorTest = true
        } catch (ex: Exception) {
            print(ex.message)
        }
    }

    private fun check(winningNumber: List<String>): List<String> {
        winningNumber.forEach { number ->
            checkBlank(number)
            checkNumber(number)
            checkBigNumber(number)
        }
        checkSize(winningNumber)
        checkDuplicates(winningNumber)
        return winningNumber
    }


    private fun checkBlank(amount: String) {
        if (amount.isBlank())
            throw IllegalArgumentException(ErrorMessage.EMPTY_PURCHASED_NUMBER)
    }

    private fun checkNumber(amount: String) {
        if (!amount.contains(Regex("^[0-9]*$")))
            throw NumberFormatException(ErrorMessage.NOT_NUMBERS)
    }

    private fun checkBigNumber(number: String) {
        if (
            number.length > 11
            || number.toLong() > Int.MAX_VALUE
            || number.toInt() < SettingValue.LOTTO_NUMBER_MINIMUM
            || number.toInt() > SettingValue.LOTTO_NUMBER_MAXIMUM
        ) throw IllegalArgumentException(ErrorMessage.OUT_OF_LOTTO_NUMBER_RANGE)
    }

    private fun checkSize(winningNumber: List<String>) {
        if (winningNumber.size != 6) throw IllegalArgumentException(ErrorMessage.NOT_INPUT_SIX_NUMBER)
    }

    private fun checkDuplicates(winningNumber: List<String>) {
        if (winningNumber.size != winningNumber.toSet().size)
            throw IllegalArgumentException(ErrorMessage.NOT_INPUT_SIX_NUMBER)
    }
}