package lotto.utils

import lotto.constants.ErrorConstants.ERROR_BONUS_NUMBER_ONLY_NUMERIC
import lotto.constants.ErrorConstants.ERROR_BONUS_NUMBER_RANGE
import lotto.constants.ErrorConstants.ERROR_PRICE_NOT_MULTIPLE_OF_1000
import lotto.constants.ErrorConstants.ERROR_PRICE_ONLY_NUMERIC
import lotto.constants.ErrorConstants.ERROR_PURCHASE_PRICE_MINIMUM
import lotto.constants.ErrorConstants.ERROR_WINNING_NUMBERS_COUNT
import lotto.constants.ErrorConstants.ERROR_WINNING_NUMBERS_DUPLICATE
import lotto.constants.ErrorConstants.ERROR_WINNING_NUMBERS_ONLY_NUMERIC
import lotto.constants.LottoConstants.COMMA

object Error {

    fun priceError(purchasePrice: String) {
        val price = purchasePrice.toIntOrNull()
            ?: throw IllegalArgumentException(ERROR_PRICE_ONLY_NUMERIC)
        if (price % 1000 != 0)
            throw IllegalArgumentException(ERROR_PRICE_NOT_MULTIPLE_OF_1000)
        if (price < 1000)
            throw IllegalArgumentException(ERROR_PURCHASE_PRICE_MINIMUM)
    }

    fun winningNumberError(winningNumbers: String) {
        val numbers = winningNumbers.split(COMMA)
            .map {
                it.toIntOrNull()
                    ?: throw IllegalArgumentException(ERROR_WINNING_NUMBERS_ONLY_NUMERIC)
            }
        if (numbers.size != 6)
            throw IllegalArgumentException(ERROR_WINNING_NUMBERS_COUNT)
        if (numbers.toSet().size != 6)
            throw IllegalArgumentException(ERROR_WINNING_NUMBERS_DUPLICATE)
    }

    fun bonusNumberError(bonusNumber: String) {
        val number = bonusNumber.toIntOrNull()
            ?: throw IllegalArgumentException(ERROR_BONUS_NUMBER_ONLY_NUMERIC)
        if (number !in 1..45)
            throw IllegalArgumentException(ERROR_BONUS_NUMBER_RANGE)
    }
}
