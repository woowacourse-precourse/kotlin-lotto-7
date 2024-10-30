package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }

    fun winningCount(inputNumbers: InputNumbers): Int {
        var winningCount = 0
        for (i in numbers.indices) {
            winningCount += numbers.count { it == inputNumbers.winningNumbers[i] }
        }

        return winningCount
    }

    fun isBonus(inputNumbers: InputNumbers): Boolean {
        if (winningCount(inputNumbers) == 5) {
            if (numbers.contains(inputNumbers.bonusNumber)) return true
        }

        return false
    }

    override fun toString(): String {
        return numbers.toString()
    }
}
