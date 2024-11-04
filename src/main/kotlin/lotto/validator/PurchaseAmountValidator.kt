package lotto.validator

import lotto.exception.ExceptionCode
import lotto.exception.LottoException

const val PURCHASE_AMOUNT_UNIT = 1_000
private const val PURCHASE_AMOUNT_LOWER_BOUND = 1_000
private const val PURCHASE_AMOUNT_UPPER_BOUND = 100_000

object PurchaseAmountValidator {
    fun validate(input: String) {
        validateNumeric(input)
        validateUnit(input)
        validateBound(input)
    }

    private fun validateNumeric(input: String) {
        input.toIntOrNull() ?: throw LottoException(ExceptionCode.INVALID_NUMERIC)
    }

    private fun validateUnit(input: String) {
        if (input.toInt() % PURCHASE_AMOUNT_UNIT != 0) {
            throw LottoException(ExceptionCode.INVALID_PURCHASE_AMOUNT_UNIT)
        }
    }

    private fun validateBound(input: String) {
        if (input.toInt() !in PURCHASE_AMOUNT_LOWER_BOUND..PURCHASE_AMOUNT_UPPER_BOUND) {
            throw LottoException(ExceptionCode.OUT_OF_BOUND_PURCHASE_AMOUNT)
        }
    }
}