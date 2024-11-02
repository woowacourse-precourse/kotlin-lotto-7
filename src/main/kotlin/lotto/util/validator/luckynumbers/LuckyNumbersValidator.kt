package lotto.util.validator.luckynumbers

import lotto.util.validator.luckynumbers.LuckyNumbersErrorType.*

class LuckyNumbersValidator(
    private val inputLuckyNumbers: String
) {
    private val luckyNumbers: List<String> = inputLuckyNumbers.split(DELIMITER)
    private val parsedInteger: List<Int?> = luckyNumbers.map { it.trim().toIntOrNull() }
    private val parsedDecimal: List<Double?> = luckyNumbers.map { it.trim().toDoubleOrNull() }

    fun validateLuckyNumbers() {
        checkEmpty()
        checkIsDelimiter()
        checkDecimal()
        checkInteger()
        checkNumberBetween1And45()
        checkDuplicate()
        checkLuckyNumber6()
    }

    private fun checkEmpty() {
        if (inputLuckyNumbers.isEmpty()) throw IllegalArgumentException(EMPTY_INPUT.errorMessage)
    }

    private fun checkIsDelimiter() {
        if (DELIMITER !in inputLuckyNumbers) throw IllegalArgumentException(N0_COMMA.errorMessage)
    }

    private fun checkDecimal() {
        parsedDecimal.forEach {
            if (it != null && it % ONE != ZERO_EXPRESSED_IN_DECIMAL) throw IllegalArgumentException(
                NOT_DECIMAL.errorMessage
            )
        }
    }

    private fun checkInteger() {
        parsedInteger.forEach {
            if (it == null) throw IllegalArgumentException(
                NOT_INTEGER.errorMessage
            )
        }
    }

    private fun checkNumberBetween1And45() {
        parsedInteger.forEach {
            if (it !in START_NUMBER..END_NUMBER) throw IllegalArgumentException(LUCKY_NUMBERS_RANGE.errorMessage)
        }
    }

    private fun checkDuplicate() {
        if (parsedInteger.toSet().size != parsedInteger.size) throw IllegalArgumentException(NO_DUPLICATE_LUCKY_NUMBERS.errorMessage)
    }

    private fun checkLuckyNumber6() {
        if (parsedInteger.size != NUMBER_OF_LUCKY_NUMBER) throw IllegalArgumentException(LUCKY_NUMBERS_6.errorMessage)
    }

    companion object {
        private const val ZERO_EXPRESSED_IN_DECIMAL: Double = 0.0
        private const val ONE: Int = 1
        private const val START_NUMBER: Int = 1
        private const val END_NUMBER: Int = 45
        private const val DELIMITER: String = ","
        private const val NUMBER_OF_LUCKY_NUMBER: Int = 6
    }
}