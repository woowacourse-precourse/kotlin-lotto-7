package lotto.util.validator.bonusnumber

import lotto.domain.model.Lotto
import lotto.util.validator.bonusnumber.BonusNumberErrorType.*

class BonusNumberValidator(
    private val lotto: Lotto,
    private val bonusNumber: String
) {
    private val parsedInteger: Int? = bonusNumber.toIntOrNull()
    private val parsedDecimal: Double? = bonusNumber.toDoubleOrNull()

    fun validateBonusNumber() {
        checkEmpty()
        checkDecimal()
        checkInteger()
        checkNumberBetween1And45()
        checkDuplicateWithLuckyNumbers()
    }

    private fun checkEmpty() {
        if (bonusNumber.isEmpty()) throw IllegalArgumentException(EMPTY_INPUT.errorMessage)
    }

    private fun checkDecimal() {
        if (parsedDecimal != null && parsedDecimal % ONE != ZERO_EXPRESSED_IN_DECIMAL) throw IllegalArgumentException(
            NOT_DECIMAL.errorMessage
        )
    }

    private fun checkInteger() {
        if (parsedInteger == null) throw IllegalArgumentException(
            NOT_INTEGER.errorMessage
        )
    }

    private fun checkNumberBetween1And45() {
        val isValidBonusNumber: Boolean = parsedInteger in START_NUMBER..END_NUMBER
        if (!isValidBonusNumber) throw IllegalArgumentException(BONUS_NUMBER_RANGE.errorMessage)
    }

    private fun checkDuplicateWithLuckyNumbers() {
        parsedInteger?.let {
            if (it in lotto.luckyNumbers) throw IllegalArgumentException(NO_DUPLICATE_LUCKY_NUMBERS.errorMessage)
        }
    }

    companion object {
        private const val ZERO_EXPRESSED_IN_DECIMAL: Double = 0.0
        private const val ONE: Int = 1
        private const val START_NUMBER: Int = 1
        private const val END_NUMBER: Int = 45
    }
}