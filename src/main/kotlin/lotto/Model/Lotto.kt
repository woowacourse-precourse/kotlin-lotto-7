package lotto.Model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.all { it in 1..45 }) { "[ERROR] 로또 번호는 1부터 45 사이의 정수여야 합니다." }
        require(numbers.distinct().size == numbers.size) { "[ERROR] 로또 번호에는 중복이 있을 수 없습니다." }
        require(numbers.all { it >= 0 }) { "[ERROR] 로또 번호에는 음수가 포함될 수 없습니다." }
    }

    fun getNumbers(): List<Int> = numbers.sorted()
}