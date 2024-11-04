package lotto.validator

import lotto.util.Constants
import lotto.util.ExceptionConstants

class Validator {

    fun validatePurchaseAmount(amountString: String) {
        require(amountString.isNotBlank()) { ExceptionConstants.ERROR_EMPTY_PURCHASE_AMOUNT }
        require(amountString.all { it.isDigit() }) { ExceptionConstants.ERROR_NOT_A_NUMBER }
        require(amountString.toBigInteger() <= Int.MAX_VALUE.toBigInteger()) { ExceptionConstants.ERROR_OUT_OF_RANGE }

        val amount = amountString.toInt()

        require(amount > 0) { ExceptionConstants.ERROR_INVALID_PURCHASE_AMOUNT }
        require(amount % Constants.LOTTO_UNIT_PRICE == 0) { ExceptionConstants.ERROR_INVALID_PURCHASE_AMOUNT }
    }

    fun validateWinningNumbers(numbers: List<Int>) {
        require(numbers.isNotEmpty()) { ExceptionConstants.ERROR_EMPTY_WINNING_NUMBERS }
        require(numbers.size == Constants.WINNING_NUMBERS_COUNT) { ExceptionConstants.ERROR_INVALID_WINNING_NUMBERS_COUNT }
        require(numbers.all { it in Constants.MIN_NUMBER..Constants.MAX_NUMBER }) { ExceptionConstants.ERROR_INVALID_WINNING_NUMBERS_RANGE }
        require(numbers.distinct().size == Constants.WINNING_NUMBERS_COUNT) { ExceptionConstants.ERROR_DUPLICATE_WINNING_NUMBERS }
    }

    fun validateBonusNumber(bonusNumber: Int, winningNumbers: List<Int>) {
        require(winningNumbers.isNotEmpty()) { ExceptionConstants.ERROR_EMPTY_BONUS_NUMBERS }
        require(bonusNumber in Constants.MIN_NUMBER..Constants.MAX_NUMBER) { ExceptionConstants.ERROR_INVALID_BONUS_NUMBER }
        require(bonusNumber !in winningNumbers) { ExceptionConstants.ERROR_DUPLICATE_BONUS_NUMBER }
    }
}