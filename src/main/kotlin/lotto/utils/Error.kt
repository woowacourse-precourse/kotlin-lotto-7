package lotto.utils

import lotto.constants.ErrorConstants.ERROR_INPUTNUMBER_BONUSNUMBER_DUPLICATE
import lotto.constants.ErrorConstants.ERROR_NUMBERS_COUNT
import lotto.constants.ErrorConstants.ERROR_NUMBERS_DUPLICATE
import lotto.constants.ErrorConstants.ERROR_NUMBER_ONLY_NUMERIC
import lotto.constants.ErrorConstants.ERROR_NUMBER_RANGE
import lotto.constants.ErrorConstants.ERROR_PRICE_NOT_MULTIPLE_OF_1000
import lotto.constants.LottoConstants.COMMA
import lotto.constants.LottoConstants.LOTTO_NUMBER_RANGE
import lotto.constants.LottoConstants.LOTTO_PRICE
import lotto.constants.LottoConstants.MAX_LOTTO_NUMBER
import lotto.constants.LottoConstants.MIN_LOTTO_NUMBER

object Error {

    fun priceError(purchasePrice: String) {
        val price = purchasePrice.toIntOrNull()
            ?: throw IllegalArgumentException(ERROR_NUMBER_ONLY_NUMERIC)

        if (price % LOTTO_PRICE != 0)
            throw IllegalArgumentException(ERROR_PRICE_NOT_MULTIPLE_OF_1000)
    }

    fun winningNumberError(winningNumbers: String) {
        val numbers = winningNumbers
            .split(COMMA)
            .map {
                it.toIntOrNull()
                    ?: throw IllegalArgumentException(ERROR_NUMBER_ONLY_NUMERIC)
            }

        if (numbers.size != LOTTO_NUMBER_RANGE)
            throw IllegalArgumentException(ERROR_NUMBERS_COUNT)
        if (numbers.toSet().size != numbers.size)
            throw IllegalArgumentException(ERROR_NUMBERS_DUPLICATE)
        if (!numbers.all { it in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER })
            throw IllegalArgumentException(ERROR_NUMBER_RANGE)
    }

    fun bonusNumberError(bonusNumber: String, winningNumbers: String) {
        val number = bonusNumber.toIntOrNull()
            ?: throw IllegalArgumentException(ERROR_NUMBER_ONLY_NUMERIC)

        if (number !in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER)
            throw IllegalArgumentException(ERROR_NUMBER_RANGE)
        if (winningNumbers.contains(bonusNumber))
            throw IllegalArgumentException(ERROR_INPUTNUMBER_BONUSNUMBER_DUPLICATE)
    }
}
