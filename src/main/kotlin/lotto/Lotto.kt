package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.toSet().size == 6) { "[ERROR] 로또 번호는 중복되지 않아야 합니다." }
        require(numbers.all { number ->
            number in 1..45
        }) { "[ERROR] 로또 번호는 1부터 45 사이여야 합니다." }
    }

    fun getNumbers(): List<Int> = numbers.sorted()
}
