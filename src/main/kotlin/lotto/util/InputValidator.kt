package lotto.util

import lotto.util.ErrorMessages.ERROR_BONUS_DUPLICATE
import lotto.util.ErrorMessages.ERROR_INCORRECT_UNIT
import lotto.util.ErrorMessages.ERROR_NOT_A_NUMBER
import lotto.util.ErrorMessages.ERROR_NUMBER_RANGE
import lotto.util.ErrorMessages.ERROR_UNVALIDATED_NUMBER

class InputValidator {
    fun validatePurchasePrice(inputPrice: String): Int? {
        return runCatching {
            val sanitizedInput = inputPrice.replace(",", "")
            require(sanitizedInput.all { it.isDigit() }) { ERROR_NOT_A_NUMBER }

            val price = sanitizedInput.toInt()
            require(price % 1000 == 0) { ERROR_INCORRECT_UNIT }
            price
        }.onFailure {
            println(it.message ?: ERROR_UNVALIDATED_NUMBER)
        }.getOrNull()
    }

    fun validateWinningNumbers(inputNumbers: String): List<Int>? {
        return runCatching {
            val numbers = inputNumbers.split(",")
                .map { it.trim().toInt() }

            NumberValidation.validate(numbers)
            numbers
        }.onFailure {
            println(it.message ?: ERROR_UNVALIDATED_NUMBER)
        }.getOrNull()
    }

    fun validateBonusNumber(input: String, winningNumbers: List<Int>): Int? {
        return runCatching {
            val bonusNumber = input.trim().toInt()
            require(NumberValidation.RANGE.isValid(listOf(bonusNumber))) { ERROR_NUMBER_RANGE }
            require(bonusNumber !in winningNumbers) { ERROR_BONUS_DUPLICATE }
            bonusNumber
        }.onFailure {
            println(it.message ?: ERROR_UNVALIDATED_NUMBER)
        }.getOrNull()
    }
}