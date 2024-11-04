package lotto.util

import lotto.constants.Exceptions

class Validator {
    fun validatePriceRange(tempPrice: Int) =
        require(tempPrice in MIN_PRICE..MAX_PRICE) { Exceptions.NOT_BETWEEN_PRICE_RANGE }

    fun validatePriceUnit(tempPrice: Int) =
        require(tempPrice % MIN_PRICE == 0) { Exceptions.INVALID_PRICE_UNIT }

    fun validateLottoNumberRange(tempWinningNumber: Int) =
        require(tempWinningNumber in MIN_NUMBER..MAX_NUMBER) { Exceptions.NOT_BETWEEN_NUMBER_RANGE }

    companion object {
        private const val MIN_PRICE = 1000
        private const val MAX_PRICE = 100000

        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
    }
}