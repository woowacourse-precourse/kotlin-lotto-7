package utils

import utils.ErrorMessages.BONUS_NUMBER_DUPLICATE_ERROR
import utils.ErrorMessages.BONUS_NUMBER_NUMBER_ERROR
import utils.ErrorMessages.BONUS_NUMBER_RANGE_ERROR
import utils.ErrorMessages.MONEY_1000_UNIT_ERROR
import utils.ErrorMessages.MONEY_MAX_VALUE_ERROR
import utils.ErrorMessages.MONEY_NUMBER_ERROR
import utils.ErrorMessages.MONEY_POSITIVE_ERROR
import utils.ErrorMessages.WINNING_NUMBERS_COUNT_ERROR
import utils.ErrorMessages.WINNING_NUMBERS_DUPLICATE_ERROR
import utils.ErrorMessages.WINNING_NUMBERS_NUMBER_ERROR
import utils.ErrorMessages.WINNING_NUMBERS_RANGE_ERROR
import utils.ExtensionUtil.getInt

object Validator {

    fun validateMoney(inputMoney: String): Int {

        MoneyValidator.SHOULD_BE_NUMBER.validate(inputMoney)

        MoneyValidator.SHOULD_BE_POSITIVE.validate(inputMoney)

        MoneyValidator.SHOULD_BE_1000_UNIT.validate(inputMoney)

        MoneyValidator.SHOULD_BE_UNDER_MAX.validate(inputMoney)

        return inputMoney.toInt()
    }

    fun validateWinningNumbers(inputWinningNumbers: String) {
        val winningNumbers = inputWinningNumbers.split(",")

        require(winningNumbers.size == 6) { WINNING_NUMBERS_COUNT_ERROR }

        val numbers = winningNumbers.map {
            it.getInt()
                ?: throw IllegalArgumentException(WINNING_NUMBERS_NUMBER_ERROR)
        }

        require(numbers.all { it in 1..45 }) { WINNING_NUMBERS_RANGE_ERROR }

        require(numbers.toSet().size == 6) { WINNING_NUMBERS_DUPLICATE_ERROR }
    }

    fun validateBonusNumber(inputBonusNumber: String, winningNumbers: List<Int>) {
        val bonusNumber =
            inputBonusNumber.getInt() ?: throw IllegalArgumentException(BONUS_NUMBER_NUMBER_ERROR)

        require(bonusNumber in 1..45) { BONUS_NUMBER_RANGE_ERROR }
        require(bonusNumber in winningNumbers) { BONUS_NUMBER_DUPLICATE_ERROR }

    }


}