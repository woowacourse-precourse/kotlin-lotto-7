package lotto.model

import lotto.dto.WinningTicket
import lotto.model.LottoWinning.*

class LottoResultCalculator(
    private val winningTicket: WinningTicket
) {

    private val results = mutableMapOf(
        FIRST to 0,
        SECOND to 0,
        THIRD to 0,
        FOURTH to 0,
        FIFTH to 0,
        NONE to 0
    )

    fun countMatchingNumber(lottos: List<Lotto>): MutableMap<LottoWinning, Int> {
        for (lotto in lottos) {
            val matchingCount = lotto.countMatching(winningTicket.lotto)
            matchResult(matchingCount, lotto)
        }

        return results
    }

    private fun matchResult(matchingCount: Int, lotto: Lotto) {
        when (matchingCount) {
            FIRST.count -> results[FIRST] = results[FIRST]!! + 1
            SECOND.count ->
                if (lotto.contain(winningTicket.bonusNumber)) results[SECOND] = results[SECOND]!! + 1
                else results[THIRD] = results[THIRD]!! + 1

            FOURTH.count -> results[FOURTH] = results[FOURTH]!! + 1
            FIFTH.count -> results[FIFTH] = results[FIFTH]!! + 1
            else -> results[NONE] = results[NONE]!! + 1
        }
    }

    fun calculateTotalReward(): Int {
        var totalReward = 0
        results.keys.forEach { key ->
            totalReward += key.prize * results[key]!!
        }
        return totalReward
    }

    fun calculateProfitRate(lottoCount: Int, totalReward: Int): Double {
        return totalReward.toDouble() / (lottoCount * 1000) * 100
    }
}