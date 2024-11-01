package lotto

import camp.nextstep.edu.missionutils.Console

class BonusNumber {
    init {
        bonusNumberMessege()
    }

    private var validatorTest = false
    private var bonusNumber = ""

    fun bonusNumber(winningNumber: List<String>): Int {
        while (!validatorTest) {
            bonusNumberException(winningNumber)
        }
        return bonusNumber.toInt()
    }

    private fun bonusNumberException(winningNumber: List<String>): Any {
        try {
            bonusNumber = bonusNumberInput()
            checkBlank(bonusNumber)
            checkNumber(bonusNumber)
            checkRange(bonusNumber)
            checkDuplicate(bonusNumber, winningNumber)
            validatorTest = true
            return bonusNumber
        } catch (ex: Exception) {
            return println(ex.message)
        }
    }

    private fun bonusNumberInput(): String {
        return Console.readLine()
    }

    private fun checkBlank(bonusNumber: String) {
        require(bonusNumber.isNotBlank()) { ExceptionMessage.BLANK }
    }

    private fun checkNumber(bonusNumber: String) {
        require(bonusNumber.contains(Regex("^[0-9]*$"))) { ExceptionMessage.NOT_NUMBERS }
    }

    private fun checkRange(bonusNumber: String) {
        require(bonusNumber.toInt() in 1..45) { ExceptionMessage.NOT_LOTTO_NUMBER_RANGE }
    }

    private fun checkDuplicate(bonusNumber: String, winningNumber: List<String>) {
        require(!winningNumber.contains(bonusNumber)) { ExceptionMessage.DUPLICATED_NUMBERS }
    }

    private fun bonusNumberMessege() {
        return println(Message.ENTER_BONUS_NUMBER)
    }
}