package lotto.domain.model

import lotto.domain.exception.ExceptionMessages

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == VALID_LOTTO_NUMBER_LENGTH) { ExceptionMessages.INVALID_LOTTO_NUMBER_LENGTH }
        require(numbers.distinct().size == numbers.size) { ExceptionMessages.DUPLICATE_NUMBER_EXISTS }
        require(numbers.all { number -> number in VALID_LOTTO_NUMBER_RANGE }) {
            ExceptionMessages.NUMBER_OUT_OF_VALID_LOTTO_RANGE_EXISTS
        }
    }

    override fun toString(): String = numbers.sorted().toString()

    companion object {
        const val LOTTO_PRICE = 1_000
        const val VALID_LOTTO_NUMBER_LENGTH = 6
        val VALID_LOTTO_NUMBER_RANGE = 1..45
    }
}
