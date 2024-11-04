package lotto.validator

import lotto.util.Constants.LOTTO_NUMBER_COUNT
import lotto.util.Constants.LOTTO_PRICE_UNIT
import lotto.util.Constants.MAX_LOTTO_NUMBER
import lotto.util.Constants.MIN_LOTTO_NUMBER
import lotto.util.ErrorType

class InputValidator {

    fun validatePriceInput(price: String) {
        if (price.isEmpty()) {
            throw IllegalStateException(ErrorType.PRICE_EMPTY)
        }

        NumberValidator.validateInteger(price)

        require(price.toInt() % LOTTO_PRICE_UNIT == 0) {
            ErrorType.PRICE_NOT_1000_UNIT
        }
    }
}