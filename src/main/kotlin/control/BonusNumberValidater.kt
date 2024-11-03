package control

import data.Lotto
import view.ErrorMessage
import view.Input

class BonusNumberValidater {
    private var validatorTest = false
    private lateinit var bonusNumber: String

    fun validate(winningNumber: Lotto): Int {
        while (!validatorTest) {
            bonusNumber = Input().bonusNumberInput()
            bonusNumberException(winningNumber)
        }
        return bonusNumber.toInt()
    }

    private fun bonusNumberException(winningNumber: Lotto): Any {
        try {
            checkBlank(bonusNumber)
            checkNumber(bonusNumber)
            checkBigNumber(bonusNumber)
            checkIntRange(bonusNumber)
            checkLottoRange(bonusNumber)
            checkDuplicate(bonusNumber, winningNumber)
            validatorTest = true
            return bonusNumber
        } catch (ex: Exception) {
            return print(ex.message)
        }
    }

    private fun checkBlank(bonusNumber: String) {
        require(bonusNumber.isNotBlank()) { ErrorMessage.BLANK }
    }

    private fun checkNumber(bonusNumber: String) {
        require(bonusNumber.contains(Regex("^[0-9]*$"))) {
            throw IllegalArgumentException(
                ErrorMessage.NOT_NUMBERS
            )
        }
    }

    private fun checkBigNumber(amount: String) {
        require(amount.length < 11) { ErrorMessage.OUT_OF_LOTTO_NUMBER_RANGE }
    }

    private fun checkIntRange(amount: String) {
        require(amount.toLong() < Int.MAX_VALUE) { ErrorMessage.OUT_OF_LOTTO_NUMBER_RANGE }
    }

    private fun checkLottoRange(bonusNumber: String) {
        require(bonusNumber.toInt() in 1..45) { ErrorMessage.OUT_OF_LOTTO_NUMBER_RANGE }
    }

    private fun checkDuplicate(bonusNumber: String, winningNumber: Lotto) {
        require(!winningNumber.contains(bonusNumber.toInt())) { ErrorMessage.DUPLICATED_NUMBERS }
    }
}