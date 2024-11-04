package lotto.view

import lotto.util.ErrorMessages

class Bonus(private val number: Int) {
    init {
        validateNumber()
    }

    private fun validateNumber() {
        require(number in LOWER_RANGE_LOTTO_NUMBER..UPPER_RANGE_LOTTO_NUMBER) {
            ErrorMessages.ERROR_RANGE_NUMBER.message
        }
    }

    companion object {
        private const val LOWER_RANGE_LOTTO_NUMBER = 1
        private const val UPPER_RANGE_LOTTO_NUMBER = 45
    }
}