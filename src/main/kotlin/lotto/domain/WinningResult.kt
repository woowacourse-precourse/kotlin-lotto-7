package lotto.domain

import lotto.constants.OutputConstants.HUNDRED_PERCENT
import lotto.constants.OutputConstants.TWO_DECIMAL_FORMAT

class WinningResult(private val lottos: List<Lotto>, private val inputNumbers: InputNumbers) {
    private var countByMatchCount = mutableListOf(0, 0, 0, 0, 0)

    private fun getMatchCount(): MutableList<Int> {
        lottos.forEachIndexed { index, lotto ->
            when (lotto.winningCount(inputNumbers)) {
                3 -> countByMatchCount[0]++
                4 -> countByMatchCount[1]++
                5 -> getBonusCount(index)
                6 -> countByMatchCount[4]++
            }
        }

        return countByMatchCount
    }

    private fun getBonusCount(i: Int): Int {
        if (lottos[i].isBonus(inputNumbers)) return countByMatchCount[3]++

        return countByMatchCount[2]++
    }

    fun getRateOfReturn(purchasedPrice: String): Float {
        val totalPrize = Ranking.entries
            .mapIndexed { index, ranking -> countByMatchCount[index] * ranking.prize }
            .sum()
        val rate = totalPrize / purchasedPrice.toFloat() * HUNDRED_PERCENT
        val formatedRate = String.format(TWO_DECIMAL_FORMAT, rate).toFloat()

        return formatedRate
    }

    fun getPrizeRankMessage(): List<String> {
        countByMatchCount = getMatchCount()

        return Ranking.entries.mapIndexed { index, ranking ->
            "${ranking.formattedMessage()}${countByMatchCount[index]}"
        }
    }
}
