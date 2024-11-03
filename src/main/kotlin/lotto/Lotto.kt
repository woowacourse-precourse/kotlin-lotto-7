package lotto

class Lotto(private val numbers: List<Int>) {
    fun checkRank(winningNumbers: WinningNumbers, bonusNumber: BonusNumber): Int {
        val countedSameNumber = checkNumbers(winningNumbers, bonusNumber)

        if (countedSameNumber["sameWithWinningNumbers"] == 5 && countedSameNumber["sameWithBonusNumber"] == 1) {
            return 2
        }
        return when(countedSameNumber["sameWithWinningNumbers"]) {
            6 -> 1
            5 -> 3
            4 -> 4
            3 -> 5
            else -> 0
        }
    }

    fun checkNumbers(winningNumbers: WinningNumbers, bonusNumber: BonusNumber): Map<String, Int>  {
        val countedSameNumber = mutableMapOf("sameWithWinningNumbers" to 0, "sameWithBonusNumber" to 0)
        val countWinningNumber = numbers.filter { winningNumbers.winningNumbers.contains(it) }

        countedSameNumber["sameWithWinningNumbers"] = countWinningNumber.size
        if (numbers.contains(bonusNumber.bonusNumber)) {
            countedSameNumber["sameWithBonusNumber"] = 1
        }
        return countedSameNumber
    }
}