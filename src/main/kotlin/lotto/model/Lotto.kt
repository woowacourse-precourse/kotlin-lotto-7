package lotto.model

import lotto.constants.Constants.LOTTO_SIZE
import lotto.constants.Exceptions

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE) { Exceptions.INVALID_NUMBERS_SIZE }
        require(numbers.size == numbers.distinct().size) { Exceptions.DUPLICATED_NUMBERS }
    }
}
