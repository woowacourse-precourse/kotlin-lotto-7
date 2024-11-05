package lotto.util

import lotto.model.Lotto
import java.lang.NumberFormatException

class Validator {

    fun validateMoneyInput(money: String) {
        isNumber(money)
        isThousandUnit(money)
        isZero(money)
    }

    private fun isNumber(money: String) {
        try {
            money.toInt()
        } catch (e: NumberFormatException) {
            println(Error.IS_NUMBER)
            throw IllegalArgumentException(Error.IS_NUMBER)
        }
    }

    private fun isZero(money: String) {
        if (money.toInt() == 0) {
            println(Error.GIVE_ME_MONEY)
            throw IllegalArgumentException(Error.GIVE_ME_MONEY)
        }
    }

    private fun isThousandUnit(money: String) {
        if (money.toInt() % 1000 != 0) {
            println(Error.IS_THOUSAND_UNITS)
            throw IllegalArgumentException(Error.IS_THOUSAND_UNITS)
        }
    }

    fun validateWinningNumberInput(winningNumber: String) {
        validateLottoFormat(winningNumber)
    }

    private fun validateLottoFormat(winningNumber: String) {
        val reg = Regex("[0-9]+,[0-9]+,[0-9]+,[0-9]+,[0-9]+,[0-9]+")
        if (!reg.matches(winningNumber)) {
            println(Error.LOTTERY_FORMAT)
            throw IllegalArgumentException(Error.LOTTERY_FORMAT)
        }
    }

    fun validateBonusNumberInput(bonusNumber: String, winningNumber: Lotto) {
        isNumber(bonusNumber)
        validateBonusNumberrange(bonusNumber)
        validateBonusDuplication(bonusNumber, winningNumber)
    }

    private fun validateBonusNumberrange(bonusNumber: String) {
        if (bonusNumber.toInt() > 45 || bonusNumber.toInt() < 1) {
            println(Error.LOTTERY_RANGE)
            throw IllegalArgumentException(Error.LOTTERY_FORMAT)
        }
    }

    private fun validateBonusDuplication(bonusNumber: String, winningNumber: Lotto) {
        if (winningNumber.getNumbers().contains(bonusNumber.toInt())) {
            println(Error.DUPLICATION_WITH_WINNING)
            throw IllegalArgumentException(Error.DUPLICATION_WITH_WINNING)
        }
    }
}