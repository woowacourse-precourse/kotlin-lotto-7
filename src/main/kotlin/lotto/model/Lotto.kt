package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.toSet().size == 6) { "[ERROR] 로또 번호에 중복된 숫자가 있습니다." }
    }

    fun contain(number: Int): Boolean {
        return numbers.contains(number)
    }

    fun countMatching(target: Lotto): Int {
        return numbers.count { target.contain(it) }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}