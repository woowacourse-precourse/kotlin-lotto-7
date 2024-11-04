package Validation

import Utils.InputUtils

class InputValidation {
    fun isValidUnit(money: Int): Boolean {
        return money % InputUtils.MONEY_UNIT == 0
    }
}