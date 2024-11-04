package lotto.validator

import lotto.util.Constants
import lotto.util.ExceptionConstants

class Validator {

    fun validatePurchaseAmount(amountString: String) {
        require(amountString.isNotBlank()) { ExceptionConstants.ERROR_EMPTY_PURCHASE_AMOUNT }
        require(amountString.all { it.isDigit() }) { ExceptionConstants.ERROR_NOT_A_NUMBER }
        require(amountString.toBigInteger() <= Int.MAX_VALUE.toBigInteger()) { ExceptionConstants.ERROR_OUT_OF_RANGE }

        val amount = amountString.toInt()

        require(amount > 0) { ExceptionConstants.ERROR_INVALID_PURCHASE_AMOUNT }
        require(amount % Constants.LOTTO_UNIT_PRICE == 0) { ExceptionConstants.ERROR_INVALID_PURCHASE_AMOUNT }
    }
}