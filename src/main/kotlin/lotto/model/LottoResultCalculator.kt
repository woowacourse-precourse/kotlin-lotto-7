package lotto.model

import lotto.LottoWinning
import lotto.LottoWinning.*

class LottoResultCalculator(
    private val winningNumbers: Lotto,
    private val bonusNumber: Int
) {

    private val results = mutableMapOf(
        FIRST to 0,
        SECOND to 0,
        THIRD to 0,
        FOURTH to 0,
        FIFTH to 0,
        NONE to 0
    )

    fun countMatchingNumber(lottoBundle: List<Lotto>): MutableMap<LottoWinning, Int> {
        for (lotto in lottoBundle) {
            val matchingCount = lotto.countMatching(winningNumbers)
            matchResult(matchingCount, lotto)
        }

        return results
    }

    private fun matchResult(matchingCount: Int, lotto: Lotto) {
        when (matchingCount) {
            FIRST.count -> results[FIRST] = results[FIRST]!! + 1
            SECOND.count ->
                if (lotto.contain(bonusNumber)) results[SECOND] = results[SECOND]!! + 1
                else results[THIRD] = results[THIRD]!! + 1

            FOURTH.count -> results[FOURTH] = results[FOURTH]!! + 1
            FIFTH.count -> results[FIFTH] = results[FIFTH]!! + 1
            else -> results[NONE] = results[NONE]!! + 1
        }
    }
}