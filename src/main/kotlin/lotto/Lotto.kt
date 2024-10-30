package lotto

import lotto.util.ErrorMessages

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { ErrorMessages.INVALID_LOTTO_NUMBER_COUNT }
        require(numbers.distinct().count() == numbers.size) { ErrorMessages.DUPLICATE_LOTTO_NUMBER }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}
