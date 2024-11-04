package lotto.controller

import lotto.model.Lotto
import lotto.model.LottoPrize
import lotto.view.LottoView
import camp.nextstep.edu.missionutils.Randoms

class LottoController {
    fun run() {
        try {
            val purchaseAmount = LottoView.requestPurchaseAmount()
            val lottos = purchaseLottos(purchaseAmount / 1000)
            LottoView.displayPurchasedLottos(lottos.map { it.getNumbers() })

            val winningNumbers = LottoView.requestWinningNumbers()
            val bonusNumber = LottoView.requestBonusNumber()

            val results = evaluateLottos(lottos, winningNumbers, bonusNumber)
            val yield = calculateYield(purchaseAmount, results)

            LottoView.displayResults(results, yield)

        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    private fun purchaseLottos(count: Int): List<Lotto> {
        return List(count) {
            Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        }
    }

    private fun evaluateLottos(lottos: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Map<LottoPrize, Int> {
        val results = mutableMapOf<LottoPrize, Int>()
        lottos.forEach { lotto ->
            val matchCount = lotto.getNumbers().count { it in winningNumbers }
            val bonusMatch = bonusNumber in lotto.getNumbers()
            val prize = LottoPrize.findByMatchCount(matchCount, bonusMatch)

            results[prize] = results.getOrDefault(prize, 0) + 1
        }
        return results
    }

    private fun calculateYield(purchaseAmount: Int, results: Map<LottoPrize, Int>): Double {
        val totalPrize = results.entries.sumOf { (prize, count) -> prize.prizeMoney * count }
        return (totalPrize.toDouble() / purchaseAmount) * 100
    }
}
