package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }

    fun getNumbers() = numbers

    fun isValidRange(): Boolean = numbers.map { it in 1..45 }.all { it }
}
