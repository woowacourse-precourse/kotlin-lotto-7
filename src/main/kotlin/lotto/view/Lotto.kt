package lotto.view

class Lotto(private val numbers: List<Int>) {
    init {
        validateNumbers()
    }

    fun validateNumbers() {
        require(numbers.size == 6) { ERROR_SIZE_NUMBERS }
        require(numbers.size == numbers.distinct().size){ ERROR_SAME_NUMBER }
        for (number in numbers) {
            require(number in 1..45) { ERROR_NAME_LENGTH }
        }
    }

    companion object {
        private const val ERROR_SIZE_NUMBERS = "[ERROR] 로또 번호는 6개여야 합니다."
        private const val ERROR_NAME_LENGTH = "[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다."
        private const val ERROR_SAME_NUMBER = "[ERROR] 로또 번호는 중복될 수 없습니다."
    }
}