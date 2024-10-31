package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.size == numbers.distinct().size) { "[ERROR] 로또 번호는 중복되지 않아야 합니다." }
    }

    fun sort(): List<Int> {
        return numbers.sorted()
    }

    fun check(winningNumbers: List<Int>): Int {
        var winningCount = 0
        winningNumbers.forEach {
            if (numbers.contains(it)) {
                winningCount ++
            }
        }
        return winningCount
    }

    fun isBonus(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }
}
