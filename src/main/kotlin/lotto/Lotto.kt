package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { ERROR_NUMBER_SIZE_MESSAGE }
        require(numbers.toSet().size == LOTTO_NUMBER_SIZE) { ERROR_NUMBER_DUPLICATE_MESSAGE }
        require(numbers.all { it in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX }) { ERROR_NUMBER_RANGE_MESSAGE }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    fun getMatchCount(userLotto: Lotto): Int {
        return numbers.count { it in userLotto.numbers }
    }

    fun containsNumber(number: Int): Boolean {
        return numbers.contains(number)
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
        private const val LOTTO_NUMBER_MIN = 1
        private const val LOTTO_NUMBER_MAX = 45
        private const val ERROR_NUMBER_SIZE_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다."
        private const val ERROR_NUMBER_DUPLICATE_MESSAGE = "[ERROR] 로또 번호에 중복된 숫자가 있습니다."
        private const val ERROR_NUMBER_RANGE_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
    }
}
