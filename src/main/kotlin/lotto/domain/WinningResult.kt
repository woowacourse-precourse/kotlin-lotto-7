package lotto.domain

class WinningResult(private val lottos: List<Lotto>) {
    private val countByMatchCount = mutableListOf(0, 0, 0, 0, 0)

    fun getMatchCount(inputNumbers: InputNumbers): List<Int> {
        for (i in lottos.indices)
            when (lottos[i].winningCount(inputNumbers)) {
                3 -> countByMatchCount[0]++
                4 -> countByMatchCount[1]++
                5 -> bonusCount(inputNumbers, i)
                6 -> countByMatchCount[4]++
            }
        return countByMatchCount
    }

    private fun bonusCount(inputNumbers: InputNumbers, i: Int): Int {
        if (lottos[i].isBonus(inputNumbers)) return countByMatchCount[3]++
        return countByMatchCount[2]++
    }

    fun rate(purchasedPrice: String): Float {
        val totalPrize = Ranking.entries
            .mapIndexed { index, ranking -> countByMatchCount[index] * ranking.prize }
            .sum()
        return totalPrize / purchasedPrice.toFloat() * 100
    }
}
