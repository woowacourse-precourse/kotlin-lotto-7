package lotto.data

class WinningResult(
    private val lottoNumbers: List<List<Int>>,
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {
    val details: Map<Rank, Int>

    init {
        val ranks = calculateRanks()
        details = Rank.entries
            .filter { it != Rank.MISS }
            .associateWith { rank -> ranks.count { it == rank } }
    }

    private fun calculateRanks() =
        lottoNumbers.map { numbers -> Rank.match(countMatches(numbers), containsBonus(numbers)) }

    private fun countMatches(numbers: List<Int>) = numbers.count { winningNumbers.contains(it) }

    private fun containsBonus(numbers: List<Int>) = numbers.contains(bonusNumber)
}