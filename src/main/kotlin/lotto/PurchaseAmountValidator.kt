package lotto

import lotto.PurchaseAmountErrorType.*

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
        if (parsedDecimal != null && parsedDecimal % 1 != 0.0) throw IllegalArgumentException(
            NOT_DECIMAL.errorMessage
        )
    }

    private fun validateIsInteger() {
        if (parsedInteger == null) throw IllegalArgumentException(
            NOT_INTEGER.errorMessage
        )
    }

    private fun validateIsZero() {
        if (parsedInteger == 0) throw IllegalArgumentException(
            ZERO_AMOUNT.errorMessage
        )
    }

    private fun validateUnder1000() {
        parsedInteger?.let {
            if (it < 1000) throw IllegalArgumentException(LESS_THAN_1000.errorMessage)
        }
    }

    private fun validateUnits1000() {
        parsedInteger?.let {
            if (it % 1000 != 0) throw IllegalArgumentException(NOT_UNITS_OF_1000.errorMessage)
        }
    }
}