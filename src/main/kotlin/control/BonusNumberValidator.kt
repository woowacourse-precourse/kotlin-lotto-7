package control

import data.Lotto
import util.SettingValue
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

    private fun bonusNumberException(winningNumber: Lotto) {
        try {
            checkBlank(bonusNumber)
            checkNumber(bonusNumber)
            checkBigNumber(bonusNumber)
            checkIntRange(bonusNumber)
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

    private fun checkBigNumber(amount: String) {
        if (amount.length > 11) throw IllegalArgumentException(ErrorMessage.OUT_OF_LOTTO_NUMBER_RANGE)
    }

    private fun checkIntRange(amount: String) {
        if (amount.toLong() > Int.MAX_VALUE) throw ArithmeticException(ErrorMessage.OUT_OF_LOTTO_NUMBER_RANGE)
    }

    private fun checkLottoRange(bonusNumber: String) {
        if (bonusNumber.toInt() < SettingValue.LOTTO_NUMBER_MINIMUM
            || bonusNumber.toInt() > SettingValue.LOTTO_NUMBER_MAXIMUM
        ) throw IllegalArgumentException(ErrorMessage.OUT_OF_LOTTO_NUMBER_RANGE)
    }

    private fun checkDuplicate(bonusNumber: String, winningNumber: Lotto) {
        if (winningNumber.contains(bonusNumber.toInt())) throw IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBERS)
    }
}