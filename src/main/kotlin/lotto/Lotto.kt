package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.distinct().size == 6) { "[ERROR] 로또 번호는 중복되지 않아야 합니다." }
    }

    override fun toString(): String {
        val lottoNumbersOutput = numbers.joinToString(prefix = "[", postfix = "]", separator = ", ")
        return lottoNumbersOutput
    }

    fun countMatchingNumbers(winningNumbers: List<Int>): Int {
        return numbers.intersect(winningNumbers).size
    }

    fun isBonusMatched(bonusNumber: Int): Boolean {
        return bonusNumber in numbers
    }
}
