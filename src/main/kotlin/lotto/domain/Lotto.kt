package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE) { ERROR_INVALID_SIZE_MESSAGE }
        require(numbers.toSet().size == LOTTO_SIZE) { ERROR_DUPLICATE_NUMBER_MESSAGE }
        numbers.forEach { LottoNumberValidator.validate(it) }
    }

    fun getNumbers(): List<Int> = numbers

    companion object {
        private const val ERROR_INVALID_SIZE_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다."
        private const val ERROR_DUPLICATE_NUMBER_MESSAGE = "[ERROR] 로또 번호는 중복되지 않아야 합니다."

        private const val LOTTO_SIZE = 6
    }
}
