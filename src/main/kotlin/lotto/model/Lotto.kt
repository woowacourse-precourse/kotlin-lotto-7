package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { NUMBERS_SIZE_ERROR }
        require(numbers.toSet().size == 6) { NUMBERS_DUPLICATE_ERROR }
        require(numbers.all { it in 1..45}) { NUMBERS_RANGE_ERROR }
    }

    fun getLotto(): List<Int> {
        return numbers
    }

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private const val NUMBERS_SIZE = 6

        private const val ERROR_MESSAGE = "[ERROR]"
        private const val NUMBERS_SIZE_ERROR = "$ERROR_MESSAGE 로또 번호는 ${NUMBERS_SIZE}개여야 합니다."
        private const val NUMBERS_DUPLICATE_ERROR = "$ERROR_MESSAGE 로또 번호는 중복 되지 않아야 합니다."
        private const val NUMBERS_RANGE_ERROR = "$ERROR_MESSAGE 로또 번호는 ${MIN_NUMBER}부터 $MAX_NUMBER 사이의 숫자여야 합니다."
    }
}
