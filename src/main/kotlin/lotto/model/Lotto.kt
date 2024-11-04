package lotto.model

import lotto.util.ExceptionConstants

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { ExceptionConstants.ERROR_INVALID_WINNING_NUMBERS_COUNT }
        require(numbers.all { it in 1..45 }) { ExceptionConstants.ERROR_INVALID_WINNING_NUMBERS_RANGE }
        require(numbers.distinct().size == 6) { ExceptionConstants.ERROR_DUPLICATE_WINNING_NUMBERS }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}