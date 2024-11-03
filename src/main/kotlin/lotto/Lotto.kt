package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LENGTH) { "[ERROR] 로또 번호는 ${LENGTH}개여야 합니다." }
        require(numbers.toSet().size == LENGTH) { "[ERROR] 로또 번호는 중복되면 안됩니다." }
        require(numbers.all(::isNumber)) { "[ERROR] 로또 번호는 $MIN_NUMBER ~ $MAX_NUMBER 사이의 숫자여야 합니다." }
    }

    fun matchCount(numbers: List<Int>) = numbers.count(::isMatch)
    fun isMatch(number: Int): Boolean = number in numbers

    override fun toString(): String = numbers.sorted().joinToString(", ", "[", "]")

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val LENGTH = 6
        const val PRICE = 1000
        fun isNumber(number: String) = isNumber(number.toIntOrNull() ?: 0)
        fun isNumber(number: Int) = number in MIN_NUMBER..MAX_NUMBER
    }
}
