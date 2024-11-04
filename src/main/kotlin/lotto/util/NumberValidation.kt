package lotto.util

import lotto.util.ErrorMessages.ERROR_NUMBER_DUPLICATE
import lotto.util.ErrorMessages.ERROR_NUMBER_RANGE
import lotto.util.ErrorMessages.ERROR_NUMBER_SIZE

enum class NumberValidation(val errorMessage: String) {
    SIZE(ERROR_NUMBER_SIZE) {
        override fun isValid(numbers: List<Int>) = numbers.size == 6
    },
    RANGE(ERROR_NUMBER_RANGE) {
        override fun isValid(numbers: List<Int>) = numbers.all { it in 1..45 }
    },
    NO_DUPLICATES(ERROR_NUMBER_DUPLICATE) {
        override fun isValid(numbers: List<Int>) = numbers.distinct().size == numbers.size
    };

    abstract fun isValid(numbers: List<Int>): Boolean

    companion object {
        fun validate(numbers: List<Int>) {
            values().forEach { rule ->
                require(rule.isValid(numbers)) { rule.errorMessage }
            }
        }
    }
}