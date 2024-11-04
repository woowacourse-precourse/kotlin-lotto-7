package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE) { ERROR_INVALID_SIZE_MESSAGE }
    }

    fun getNumbers(): List<Int> = numbers

    companion object {
        private const val ERROR_INVALID_SIZE_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다."

        private const val LOTTO_SIZE = 6
    }
}
