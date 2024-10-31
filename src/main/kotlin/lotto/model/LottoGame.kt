package lotto.model

class LottoGame(private val numbers: List<Int>) {
    init {
        Lotto(numbers).sort()
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