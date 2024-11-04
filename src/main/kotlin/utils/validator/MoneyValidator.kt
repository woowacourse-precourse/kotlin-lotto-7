package utils.validator

import utils.ErrorMessages.MONEY_1000_UNIT_ERROR
import utils.ErrorMessages.MONEY_MAX_VALUE_ERROR
import utils.ErrorMessages.MONEY_NUMBER_ERROR
import utils.ErrorMessages.MONEY_POSITIVE_ERROR

enum class MoneyValidator {
    SHOULD_BE_NUMBER {
        override fun validate(money: String) {
            money.toIntOrNull() ?: throw IllegalArgumentException(MONEY_NUMBER_ERROR)
        }

    },
    SHOULD_BE_POSITIVE {
        override fun validate(money: String) {
            require(money.toInt() >= 0) { MONEY_POSITIVE_ERROR }
        }
    },
    SHOULD_BE_1000_UNIT {
        override fun validate(money: String) {
            require(money.toInt() % 1000 == 0) { MONEY_1000_UNIT_ERROR }
        }
    },
    SHOULD_BE_UNDER_MAX {
        override fun validate(money: String) {
            require(money.toInt() < Int.MAX_VALUE) { MONEY_MAX_VALUE_ERROR }
        }
    };

    abstract fun validate(money: String)

}