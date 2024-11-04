package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.all { it in 1..45 }) { "[ERROR] 로또 번호는 1에서 45 사이여야 합니다." }
        require(numbers.toSet().size == numbers.size) { "[ERROR] 로또 번호는 중복될 수 없습니다."}
    }

    fun getLottoValue(): List<Int> {
        return numbers
    }
}
