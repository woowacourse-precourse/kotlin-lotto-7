package lotto.view

import camp.nextstep.edu.missionutils.Console.readLine
import lotto.utils.Constants
import lotto.utils.ErrorMessage
import lotto.utils.InputMessage

object InputView {
    fun inputLottoPrice(): Int {
        while (true) {
            try {
                println(InputMessage.INPUT_PRICE.getMessage())
                val price = validateLottoPrice(readLine())
                return price
            } catch (e: IllegalArgumentException) {
                println(e.message ?: ErrorMessage.UNKNOWN_ERROR.getMessage())
                println()
            }
        }
    }

    fun inputWinningNumbers(): List<Int> {
        while (true) {
            try {
                println(InputMessage.INPUT_WINNING_NUMBER.getMessage())
                val numbers = validateWinningNumbers(readLine())
                return numbers
            } catch (e: IllegalArgumentException) {
                println(e.message ?: ErrorMessage.UNKNOWN_ERROR.getMessage())
                println()
            }
        }
    }

    fun inputBonusNumber(): Int {
        while (true) {
            try {
                println(InputMessage.INPUT_BONUS_NUMBER.getMessage())
                val bonusNumber = validateBonusNumber(readLine())

                return bonusNumber
            } catch (e: IllegalArgumentException) {
                println(e.message ?: ErrorMessage.UNKNOWN_ERROR.getMessage())
                println()
            }
        }
    }

    private fun validateLottoPrice(inputPrice: String): Int {
        try {
            val price = inputPrice.toInt()

            if (price % Constants.LOTTO_PRICE != 0 || price == 0) {
                throw IllegalArgumentException(ErrorMessage.INVALID_AMOUNT.getMessage())
            }

            return price
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage())
        }
    }

    private fun validateWinningNumbers(inputNumbers: String): List<Int> {
        try {
            val numbers = inputNumbers.split(",").map { it.trim().toInt() }

            when {
                numbers.size != Constants.LOTTO_SIZE -> throw IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBERS.getMessage())
                numbers.any { it !in Constants.RANDOM_MIN..Constants.RANDOM_MAX } -> throw IllegalArgumentException(
                    ErrorMessage.INVALID_LOTTO_NUMBER.getMessage()
                )

                numbers.toSet().size != Constants.LOTTO_SIZE -> throw IllegalArgumentException(ErrorMessage.INVALID_DUPLICATE_NUMBER.getMessage())
            }
            return numbers
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBERS.getMessage())
        }
    }

    private fun validateBonusNumber(inputBonusNumber: String): Int {
        try {
            val bonusNumber = inputBonusNumber.toInt()
            if (bonusNumber !in Constants.RANDOM_MIN..Constants.RANDOM_MAX) {
                throw IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER.getMessage())
            }
            return bonusNumber
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER.getMessage())
        }
    }
}