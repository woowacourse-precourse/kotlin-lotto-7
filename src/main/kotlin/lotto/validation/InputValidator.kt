package lotto.validation

import lotto.extensions.*
import lotto.global.Error.*

object InputValidator {

    fun validatePurchaseAmount(input: String) {
        val error = when {
            input.isEmpty() -> EMPTY_INPUT
            input.containGap() -> CONTAINS_GAP
            input.isAboveMaximumAmount() -> ABOVE_MAXIMUM_AMOUNT
            input.isNotNumeric() -> NOT_NUMERIC
            input.isBelowMinimumAmount() -> BELOW_MINIMUM_AMOUNT
            input.isNotThousandUnit() -> NOT_THOUSAND_UNIT
            else -> return
        }
        throw IllegalArgumentException(error.message)
    }

    fun validateWinningNumbers(input: String) {
        val error = when {
            input.isEmpty() -> EMPTY_INPUT
            input.containGap() -> CONTAINS_GAP
            input.isNotNumbers() -> NOT_NUMERIC
            input.hasNotSixNumbers() -> NOT_SIX_NUMBERS
            input.hasDuplicateNumbers() -> HAS_DUPLICATE_NUMBERS
            input.areNotNumbersInRange() -> NUMBERS_OUT_OF_RANGE
            else -> return
        }
        throw IllegalArgumentException(error.message)
    }

    fun validateBonusNumber(input: String, winningNumbers: List<Int>) {
        val error = when {
            input.isEmpty() -> EMPTY_INPUT
            input.containGap() -> CONTAINS_GAP
            input.isNotNumeric() -> NOT_NUMERIC
            input.isNotNumberInRange() -> BONUS_OUT_OF_RANGE
            input.isDuplicateBonusNumber(winningNumbers) -> DUPLICATE_BONUS_NUMBER
            else -> return
        }
        throw IllegalArgumentException(error.message)
    }
}