package control

import data.Lotto
import util.SettingValue
import view.ErrorMessage
import view.Input

class BonusNumberValidator {
    private var validatorTest = false
    private lateinit var bonusNumber: String

    // Stack Overflow 방지 위해 while 구현
    fun validate(winningNumber: Lotto): Int {
        while (!validatorTest) {
            bonusNumber = Input().bonusNumberInput()
            checkException(winningNumber)
        }
        return bonusNumber.toInt()
    }

    private fun checkException(winningNumber: Lotto) {
        try {
            checkBlank(bonusNumber)
            checkNumber(bonusNumber)
            checkLottoRange(bonusNumber)
            checkDuplicate(bonusNumber, winningNumber)
            validatorTest = true
        } catch (ex: Exception) {
            print(ex.message)
        }
    }

    private fun checkBlank(amount: String) {
        if (amount.isBlank()) throw IllegalArgumentException(ErrorMessage.EMPTY_BONUS_NUMBER)
    }

    private fun checkNumber(amount: String) {
        if (!amount.contains(Regex("^[0-9]*$"))) throw NumberFormatException(ErrorMessage.NOT_NUMBERS)
    }

    private fun checkLottoRange(number: String) {
        if (
            number.length > 11 ||
            number.toLong() > Int.MAX_VALUE ||
            number.toInt() < SettingValue.LOTTO_NUMBER_MINIMUM ||
            number.toInt() > SettingValue.LOTTO_NUMBER_MAXIMUM
        ) throw IllegalArgumentException(ErrorMessage.OUT_OF_LOTTO_NUMBER_RANGE)
    }

    private fun checkDuplicate(bonusNumber: String, winningNumber: Lotto) {
        if (winningNumber.contains(bonusNumber.toInt())
        ) throw IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBERS)
    }

    internal fun checkDuplicateTest(bonusNumber: String, winningNumber: Lotto) {
        return checkDuplicate(bonusNumber, winningNumber)
    }
}