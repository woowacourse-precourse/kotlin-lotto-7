package lotto

class Lotto(
    private val numbers: List<Int>,
) {
    init {
        require(numbers.size == LOTTO_SIZE) { LOTTO_NUMBER_COUNT_ERROR }
        require(numbers.distinct().size == LOTTO_SIZE) { LOTTO_UNIQUE_NUMBER_ERROR }
        require(numbers.all { it in MINIMUM_NUMBER..MAXIMUM_NUMBER }) { LOTTO_NUMBER_RANGE_ERROR }
    }

    fun matchCount(other: Lotto): Int = numbers.intersect(other.numbers.toSet()).size

    fun contains(number: Int): Boolean = numbers.contains(number)

    fun getSortedNumbers(): List<Int> = numbers.sorted()

    companion object {
        const val LOTTO_SIZE = 6
        const val MINIMUM_NUMBER = 1
        const val MAXIMUM_NUMBER = 45
        const val PRICE = 1000

        const val LOTTO_NUMBER_COUNT_ERROR = "[ERROR] 로또 번호는 6개여야 합니다."
        const val LOTTO_UNIQUE_NUMBER_ERROR = "[ERROR] 로또 번호는 중복될 수 없습니다."
        const val LOTTO_NUMBER_RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
    }
}
