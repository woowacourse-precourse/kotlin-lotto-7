package lotto.Controller

import lotto.Model.Lotto
import lotto.Model.Prize

fun calculateResults(lottos: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Map<Prize, Int> {
    val results = mutableMapOf<Prize, Int>().withDefault { 0 }

    lottos.forEach { lotto ->
        val matchCount = lotto.getNumbers().count { it in winningNumbers }
        val isBonusMatched = bonusNumber in lotto.getNumbers()
        val prize = Prize.getPrize(matchCount, isBonusMatched)

        if (prize != null) {
            results[prize] = results.getOrDefault(prize, 0) + 1
        }
    }

    return results
}