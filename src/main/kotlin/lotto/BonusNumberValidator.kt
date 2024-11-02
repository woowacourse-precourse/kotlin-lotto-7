package lotto

import camp.nextstep.edu.missionutils.Console

class BonusNumber {
//    init {
//        bonusNumberMessege()
//    }

    private var validatorTest = false
    private var bonusNumber = ""

    fun bonusNumber(winningNumber: List<Int>): Int {
        while (!validatorTest) {
            bonusNumberException(winningNumber)
        }
        return bonusNumber.toInt()
    }

    private fun bonusNumberException(winningNumber: List<Int>): Any {
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

//    private fun bonusNumberMessege() {
//        return println(Message.ENTER_BONUS_NUMBER)
//    }
}