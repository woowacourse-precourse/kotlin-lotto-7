package lotto.utils

import lotto.constants.ErrorConstants.ERROR_NUMBERS_COUNT
import lotto.constants.ErrorConstants.ERROR_NUMBERS_DUPLICATE
import lotto.constants.ErrorConstants.ERROR_NUMBER_ONLY_NUMERIC
import lotto.constants.ErrorConstants.ERROR_NUMBER_RANGE
import lotto.constants.ErrorConstants.ERROR_PRICE_NOT_MULTIPLE_OF_1000
import lotto.constants.LottoConstants.COMMA

object Error {

    fun priceError(purchasePrice: String) {
        val price = purchasePrice.toIntOrNull()
            ?: throw IllegalArgumentException(ERROR_NUMBER_ONLY_NUMERIC)

        if (price % 1000 != 0)
            throw IllegalArgumentException(ERROR_PRICE_NOT_MULTIPLE_OF_1000)
    }

    fun winningNumberError(winningNumbers: String) {
        val numbers = winningNumbers
            .split(COMMA)
            .map {
                it.toIntOrNull()
                    ?: throw IllegalArgumentException(ERROR_NUMBER_ONLY_NUMERIC)
            }

        if (numbers.size != 6)
            throw IllegalArgumentException(ERROR_NUMBERS_COUNT)
        if (numbers.toSet().size != 6)
            throw IllegalArgumentException(ERROR_NUMBERS_DUPLICATE)
        if (!numbers.all { it in 1..45 })
            throw IllegalArgumentException(ERROR_NUMBER_RANGE)
    }

    fun bonusNumberError(bonusNumber: String) {
        val number = bonusNumber.toIntOrNull()
            ?: throw IllegalArgumentException(ERROR_NUMBER_ONLY_NUMERIC)

        if (number !in 1..45)
            throw IllegalArgumentException(ERROR_NUMBER_RANGE)
    }
}
