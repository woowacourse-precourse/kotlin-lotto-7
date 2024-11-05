package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.all { it in 1..45 }) { "[ERROR] 각 숫자는 1부터 45 사이여야 합니다." }
        require(numbers.size == numbers.toSet().size) {"[ERROR] 중복된 번호가 있습니다."}
    }
    fun getNumbers(): List<Int> {
        return numbers
    }
    fun getMatchCount(winningLotto: Lotto): Int {
        return numbers.intersect(winningLotto.numbers.toSet()).size
    }
    fun containBonusNum(number: Int): Boolean {
        return number in numbers
    }
    override fun toString(): String {
        return numbers.toString()
    }
}

