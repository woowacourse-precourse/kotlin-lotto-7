package lotto.input

import lotto.ErrorMessages

object InputValidator {
    fun validatePaymentInput(input: String) {
        require(input.isNotBlank()) { ErrorMessages.PAYMENT_IS_EMPTY }
        val payment = input.toIntOrNull()
        require(payment != null) { ErrorMessages.PAYMENT_NOT_A_NUMBER }
        require(payment > 0) { ErrorMessages.PAYMENT_NEGATIVE_NUMBER }
        require(payment % 1000 == 0) { ErrorMessages.PAYMENT_NOT_DIVISIBLE_BY_1000 }
    }

    fun validateWinningNumbersInput(input: String) {
        require(input.isNotBlank()) { ErrorMessages.WINNING_NUMBERS_EMPTY }
        val numbers = input.split(",").mapNotNull { it.toIntOrNull() }
        require(numbers.size == 6) { ErrorMessages.WINNING_NUMBERS_COUNT_IS_NOT_SIX }
        require(numbers.all { it in 1..45 }) { ErrorMessages.WINNING_NUMBER_OUT_OF_RANGE }
        require(numbers.size == numbers.distinct().size) { ErrorMessages.DUPLICATE_WINNING_NUMBERS }
    }

    fun validateBonusNumberInput(input: String) {
        require(input.isNotBlank()) { ErrorMessages.BONUS_NUMBER_EMPTY }
        val bonusNumber = input.toIntOrNull()
        require(bonusNumber != null) { ErrorMessages.BONUS_NUMBER_NOT_A_NUMBER }
        require(bonusNumber in 1..45) { ErrorMessages.BONUS_NUMBER_OUT_OF_RANGE }
    }

    fun checkIfBonusNumberDuplicated(bonusNumber: Int, winningNumbers: List<Int>) {
        require(bonusNumber !in winningNumbers) { ErrorMessages.DUPLICATE_BONUS_NUMBER }
    }

}