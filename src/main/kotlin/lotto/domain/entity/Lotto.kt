package lotto.domain.entity

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.toSet().size == 6) { HAS_DUPLICATE_NUMBER_EXCEPTION_MSG }
        require(numbers.all { it in 1..45 }) { SHOULD_BE_IN_RANGE_EXCEPTION_MSG }
    }

    fun getNumbers() = numbers

    override fun toString(): String {
        return "[" + this.numbers.joinToString(", ") + "]"
    }

    companion object {
        fun List<Int>.toLottoNumbers(): Lotto = Lotto(this)

        private const val HAS_DUPLICATE_NUMBER_EXCEPTION_MSG = "[ERROR] 중복된 로또 번호가 없어야 합니다."
        private const val SHOULD_BE_IN_RANGE_EXCEPTION_MSG = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
    }
}
