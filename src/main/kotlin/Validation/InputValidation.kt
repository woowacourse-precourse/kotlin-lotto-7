package Validation

import Utils.ExceptionUtils
import Utils.InputUtils

class InputValidation {
    fun isValidUnit(money: Int): Boolean {
        if (money % InputUtils.MONEY_UNIT == 0)
            return true
        throw IllegalArgumentException(ExceptionUtils.WRONG_UNIT_OF_MONEY_MESSAGE)
    }

    fun isValidMoney(money: Int): Boolean {
        if (money > 0)
            return true
        throw IllegalArgumentException(ExceptionUtils.WRONG_MONEY_INPUT_MESSAGE)
    }
}