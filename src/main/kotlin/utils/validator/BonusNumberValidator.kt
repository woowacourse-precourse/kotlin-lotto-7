package utils.validator

import utils.ErrorMessages.BONUS_NUMBER_DUPLICATE_ERROR
import utils.ErrorMessages.BONUS_NUMBER_NUMBER_ERROR
import utils.ErrorMessages.BONUS_NUMBER_RANGE_ERROR

enum class BonusNumberValidator {
    SHOULD_BE_NUMBER {
        override fun validate(bonusNumber: String, winningNumbers: List<Int>?) {
            bonusNumber.toIntOrNull() ?: throw IllegalArgumentException(BONUS_NUMBER_NUMBER_ERROR)
        }
    },
    SHOULD_BE_1_TO_45_NUMBER {
        override fun validate(bonusNumber: String, winningNumbers: List<Int>?) {
            require(bonusNumber.toInt() in 1..45) { BONUS_NUMBER_RANGE_ERROR }
        }
    },
    SHOULD_NOT_BE_DUPLICATE {
        override fun validate(bonusNumber: String, winningNumbers: List<Int>?) {
            require(bonusNumber.toInt() !in winningNumbers!!) { BONUS_NUMBER_DUPLICATE_ERROR }
        }
    };

    abstract fun validate(
        bonusNumber: String = "",
        winningNumbers: List<Int>? = null
    )

}