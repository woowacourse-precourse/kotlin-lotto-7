package lotto.util.validator.purchaseamount

import lotto.util.validator.purchaseamount.PurchaseAmountErrorType.*

class PurchaseAmountValidator(
    private val purchaseAmount: String
) {
    private val parsedInteger: Int? = purchaseAmount.toIntOrNull()
    private val parsedDecimal: Double? = purchaseAmount.toDoubleOrNull()

    fun validatePurchaseAmount() {
        validateIsEmpty()
        validateIsDecimal()
        validateIsInteger()
        validateIsZero()
        validateUnder1000()
        validateUnits1000()
    }

    private fun validateIsEmpty() {
        if (purchaseAmount.isEmpty()) throw IllegalArgumentException(EMPTY_INPUT.errorMessage)
    }

    private fun validateIsDecimal() {
        if (parsedDecimal != null && parsedDecimal % ONE != ZERO_EXPRESSED_IN_DECIMAL) throw IllegalArgumentException(
            NOT_DECIMAL.errorMessage
        )
    }

    private fun validateIsInteger() {
        if (parsedInteger == null) throw IllegalArgumentException(
            NOT_INTEGER.errorMessage
        )
    }

    private fun validateIsZero() {
        if (parsedInteger == ZERO) throw IllegalArgumentException(
            ZERO_AMOUNT.errorMessage
        )
    }

    private fun validateUnder1000() {
        parsedInteger?.let {
            if (it < MINIMUM_PURCHASE_AMOUNT) throw IllegalArgumentException(LESS_THAN_1000.errorMessage)
        }
    }

    private fun validateUnits1000() {
        parsedInteger?.let {
            if (it % PRICE_PER_SHEET != ZERO) throw IllegalArgumentException(NOT_UNITS_OF_1000.errorMessage)
        }
    }

    companion object {
        private const val ZERO_EXPRESSED_IN_DECIMAL = 0.0
        private const val ONE = 1
        private const val ZERO = 0
        private const val MINIMUM_PURCHASE_AMOUNT = 1000
        private const val PRICE_PER_SHEET = 1000
    }
}