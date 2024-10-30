package lotto.view

class Lotto(private val numbers: List<Int>) {
    init {
        validateNumbers()
    }

    private fun validateNumbers() {
        require(numbers.size == NUMBERS_SIZE) { ERROR_SIZE_NUMBERS }
        require(numbers.size == numbers.distinct().size){ ERROR_SAME_NUMBER }
        for (number in numbers) {
            require(number in LOWER_RANGE_LOTTO_NUMBER..UPPER_RANGE_LOTTO_NUMBER) { ERROR_RANGE_NUMBER }
        }
    }

    companion object {
        private const val ERROR_SIZE_NUMBERS = "[ERROR] 로또 번호는 6개여야 합니다."
        private const val ERROR_RANGE_NUMBER = "[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다."
        private const val ERROR_SAME_NUMBER = "[ERROR] 로또 번호는 중복될 수 없습니다."
        private const val NUMBERS_SIZE = 6
        private const val LOWER_RANGE_LOTTO_NUMBER = 1
        private const val UPPER_RANGE_LOTTO_NUMBER = 45
    }
}