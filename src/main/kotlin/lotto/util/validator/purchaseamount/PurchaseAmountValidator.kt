package lotto.util.validator.purchaseamount

import lotto.util.validator.purchaseamount.PurchaseAmountErrorType.*

class PurchaseAmountValidator(
    private val purchaseAmount: String
) {
    private val parsedInteger: Int? = purchaseAmount.toIntOrNull()
    private val parsedDecimal: Double? = purchaseAmount.toDoubleOrNull()

    fun validatePurchaseAmount() {
        checkIsEmpty()
        checkIsDecimal()
        checkIsInteger()
        checkIsZero()
        checkUnder1000()
        checkUnits1000()
    }

    private fun checkIsEmpty() {
        if (purchaseAmount.isEmpty()) throw IllegalArgumentException(EMPTY_INPUT.errorMessage)
    }

    private fun checkIsDecimal() {
        if (parsedDecimal != null && parsedDecimal % ONE != ZERO_EXPRESSED_IN_DECIMAL) throw IllegalArgumentException(
            NOT_DECIMAL.errorMessage
        )
    }

    private fun checkIsInteger() {
        if (parsedInteger == null) throw IllegalArgumentException(
            NOT_INTEGER.errorMessage
        )
    }

    private fun checkIsZero() {
        if (parsedInteger == ZERO) throw IllegalArgumentException(
            ZERO_AMOUNT.errorMessage
        )
    }

    private fun checkUnder1000() {
        parsedInteger?.let {
            if (it < PRICE_PER_ROW) throw IllegalArgumentException(LESS_THAN_1000.errorMessage)
        }
    }

    private fun checkUnits1000() {
        parsedInteger?.let {
            if (it % PRICE_PER_ROW != ZERO) throw IllegalArgumentException(NOT_UNITS_OF_1000.errorMessage)
        }
    }

    companion object {
        private const val ZERO_EXPRESSED_IN_DECIMAL = 0.0
        private const val ONE = 1
        private const val ZERO = 0
        private const val PRICE_PER_ROW = 1000
    }
}