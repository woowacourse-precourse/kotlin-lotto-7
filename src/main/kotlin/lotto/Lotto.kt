package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }

    fun getMatchCount(winningNumbers: List<Int>): Int {
        return numbers.intersect(winningNumbers.toSet()).size
    }

    fun containsNumber(number: Int): Boolean {
        return numbers.contains(number)
    }
}
