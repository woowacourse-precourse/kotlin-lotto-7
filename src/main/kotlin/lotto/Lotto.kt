package lotto

class Lotto(
    private val numbers: List<Int>,
) {
    init {
        require(numbers.size == LOTTO_SIZE) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.distinct().size == LOTTO_SIZE) { "[ERROR] 로또 번호는 중복될 수 없습니다." }
        require(numbers.all { it in MINIMUM_NUMBER..MAXIMUM_NUMBER }) { "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다." }
    }

    fun matchCount(other: Lotto): Int = numbers.intersect(other.numbers.toSet()).size

    fun contains(number: Int): Boolean = numbers.contains(number)

    fun getSortedNumbers(): List<Int> = numbers.sorted()

    companion object {
        const val LOTTO_SIZE = 6
        const val MINIMUM_NUMBER = 1
        const val MAXIMUM_NUMBER = 45
        const val PRICE = 1000
    }
}
