package lotto.view

import lotto.util.ErrorMessages

class Lotto(private val numbers: List<Int>) {
    init {
        validateNumbers()
    }

    private fun validateNumbers() {
        require(numbers.size == NUMBERS_SIZE) {
            ErrorMessages.ERROR_SIZE_NUMBERS.message
        }
        require(numbers.size == numbers.distinct().size) {
            ErrorMessages.ERROR_SAME_NUMBER.message
        }
        numbers.forEach { number ->
            require(number in LOWER_RANGE_LOTTO_NUMBER..UPPER_RANGE_LOTTO_NUMBER) {
                ErrorMessages.ERROR_RANGE_NUMBER
            }
        }
    }

    companion object {
        private const val NUMBERS_SIZE = 6
        private const val LOWER_RANGE_LOTTO_NUMBER = 1
        private const val UPPER_RANGE_LOTTO_NUMBER = 45
    }
}