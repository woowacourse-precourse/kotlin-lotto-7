package lotto.domain

class WinningNumber(
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {

    fun getRank(lotto: Lotto): Rank {
        val matchCount: Int = getMatchCount(lotto.getNumbers())
        val matchBonus: Boolean = getMatchBonus(lotto.getNumbers())
        return Rank.valueOf(matchCount, matchBonus)
    }

    private fun getMatchCount(numbers: List<Int>): Int =
        winningNumbers.count { numbers.contains(it) }

    private fun getMatchBonus(numbers: List<Int>): Boolean = numbers.contains(bonusNumber)
}