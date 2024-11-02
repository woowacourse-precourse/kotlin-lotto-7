package lotto.model

import lotto.constants.ErrorMessage

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { ErrorMessage.LOTTO_COUNT_ERROR }
        require(numbers.distinct().size == numbers.size) { ErrorMessage.DUPLICATED_NUMBER }
    }

    fun getNumbers() = numbers
}
