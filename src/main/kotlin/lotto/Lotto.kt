package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.size == numbers.distinct().size) { "[ERROR] 중복된 값이 도출되었습니다" }
    }

    override fun toString(): String {
        return numbers.toString()
    }

    fun lotto() {}
}
