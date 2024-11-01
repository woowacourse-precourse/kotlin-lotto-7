package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }
    fun getMatchCount(winningLotto: Lotto): Int {
        return numbers.intersect(winningLotto.numbers.toSet()).size
    }
    fun contains(number: Int): Boolean {
        return number in numbers
    }
    override fun toString(): String {
        return numbers.toString()
    }
}

