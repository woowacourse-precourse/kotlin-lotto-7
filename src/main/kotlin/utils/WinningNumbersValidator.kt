package utils

import utils.ErrorMessages.WINNING_NUMBERS_COUNT_ERROR
import utils.ErrorMessages.WINNING_NUMBERS_DUPLICATE_ERROR
import utils.ErrorMessages.WINNING_NUMBERS_NUMBER_ERROR
import utils.ErrorMessages.WINNING_NUMBERS_RANGE_ERROR
import utils.ExtensionUtil.getInt

enum class WinningNumbersValidator {
    SHOULD_BE_SIX_COUNT {
        override fun validate(winningNumbers: List<String>) {
            require(winningNumbers.size == 6) { WINNING_NUMBERS_COUNT_ERROR }
        }
    },
    SHOULD_BE_NUMBER {
        override fun validate(winningNumbers: List<String>) {
            winningNumbers.map {
                it.getInt() ?: throw IllegalArgumentException(WINNING_NUMBERS_NUMBER_ERROR)
            }
        }
    },
    SHOULD_BE_1_TO_45_NUMBER {
        override fun validate(winningNumbers: List<String>) {
            require(winningNumbers.all { it.toInt() in 1..45 }) { WINNING_NUMBERS_RANGE_ERROR }
        }
    },
    SHOULD_NOT_BE_DUPLICATE {
        override fun validate(winningNumbers: List<String>) {
            require(winningNumbers.toSet().size == 6) { WINNING_NUMBERS_DUPLICATE_ERROR }
        }
    };

    abstract fun validate(winningNumbers: List<String>)

}