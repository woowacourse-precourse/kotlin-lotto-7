package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.size == numbers.toSet().size) { "[ERROR] 로또 번호는 중복될 수 없습니다." }
        require(numbers.all { it in 1..45 })
    }

    fun getNumbers(): List<Int> = numbers
}


