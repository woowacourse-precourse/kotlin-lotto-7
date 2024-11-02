package lotto.model

import lotto.Constants

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == Constants.LOTTO_NUMBERS_SIZE) { Constants.ERROR_LOTTO_NUMBERS_INCORRECT_SIZE }
        require(numbers.all { it in Constants.LOTTO_NUMBER_MIN..Constants.LOTTO_NUMBER_MAX }) {
            Constants.ERROR_LOTTO_NUMBERS_OUT_OF_RANGE
        }
        require(numbers.size == numbers.distinct().size) { Constants.ERROR_LOTTO_NUMBERS_DUPLICATE }
    }

    fun getNumbers(): List<Int> {
        return numbers.sorted()
    }

    fun printNumbers(): String {
        return getNumbers().joinToString(prefix = "[", postfix = "]")
    }
}
