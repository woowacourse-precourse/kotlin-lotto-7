package lotto

import view.Input

class BonusNumberValidator {
    private var validatorTest = false
    private var bonusNumber = ""

    fun validate(winningNumber: List<Int>): Int {
        while (!validatorTest) {
            bonusNumberException(winningNumber)
        }
        return bonusNumber.toInt()
    }

    private fun bonusNumberException(winningNumber: List<Int>): Any {
        try {
            bonusNumber = Input().bonusNumberInput()
            checkBlank(bonusNumber)
            checkNumber(bonusNumber)
            checkRange(bonusNumber)
            checkDuplicate(bonusNumber, winningNumber)
            validatorTest = true
            return bonusNumber
        } catch (ex: Exception) {
            return print(ex.message)
        }
    }

    private fun checkBlank(bonusNumber: String) {
        require(bonusNumber.isNotBlank()) { ErrorList.BLANK }
    }

    private fun checkNumber(bonusNumber: String) {
        require(bonusNumber.contains(Regex("^[0-9]*$"))) { ErrorList.NOT_NUMBERS }
    }

    private fun checkRange(bonusNumber: String) {
        require(bonusNumber.toInt() in 1..45) { ErrorList.NOT_LOTTO_NUMBER_RANGE }
    }

    private fun checkDuplicate(bonusNumber: String, winningNumber: List<Int>) {
        require(!winningNumber.contains(bonusNumber.toInt())) { ErrorList.DUPLICATED_NUMBERS }
    }
}