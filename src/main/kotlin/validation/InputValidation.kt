package validation

import exception.Exception
import utils.ExceptionUtils
import utils.InputUtils
import utils.LottoUtils

class InputValidation {
    fun isValidUnit(money: Int): Boolean {
        if (money % InputUtils.MONEY_UNIT == 0)
            return true
        Exception.throwException(ExceptionUtils.WRONG_UNIT_OF_MONEY_MESSAGE)
    }

    fun isValidMoney(money: Int): Boolean {
        if (money > 0)
            return true
        Exception.throwException(ExceptionUtils.WRONG_MONEY_INPUT_MESSAGE)
    }

    fun isValidWinNumbers(winNumbers: List<Int>): Boolean {
        if (winNumbers.toSet().size == LottoUtils.LOTTO_NUMBER_COUNTS)
            return true
        Exception.throwException(ExceptionUtils.WRONG_WIN_NUMBERS)
    }

    fun isinValidRange(winNumbers: List<Int>): Boolean {
        var valid = true
        for (number in winNumbers) {
            if (number < LottoUtils.MIN_VALUE || number > LottoUtils.MAX_VALUE)
                valid = false
        }
        return valid
    }

    fun isUniqueBonusNumber(winNumbers: List<Int>, bonusNumber: Int): Boolean {
        if (bonusNumber in winNumbers)
            Exception.throwException(ExceptionUtils.DUPLICATE_BONUS_NUMBER)
        return true
    }

    fun isOneBonusNumber(bonusNumber: Int): Boolean {
        if (bonusNumber == 0)
            Exception.throwException(ExceptionUtils.NOT_ONE_BONUS_NUMBER)
        return true
    }
}