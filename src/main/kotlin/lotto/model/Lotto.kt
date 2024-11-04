package lotto.model

import lotto.util.ErrorMessages

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { ErrorMessages.INVALID_NUMBER_SIZE }
        require(numbers.distinct().size == numbers.size) { ErrorMessages.DUPLICATE_NUMBERS }
        require(numbers.all { it in 1..45 }) { ErrorMessages.OUT_OF_RANGE }
        require(numbers == numbers.sorted()) { ErrorMessages.NOT_SORTED }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    override fun toString(): String {
        return numbers.toString()
    }
}
