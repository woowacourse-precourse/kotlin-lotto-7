package lotto.Controller

import camp.nextstep.edu.missionutils.Randoms
import lotto.Model.*
import lotto.View.*

class LottoController {
    fun run() {
        val purchaseAmount = inputPurchaseAmount()
        val lottoCount = purchaseAmount / 1000
        val purchasedLottos = generateLottos(lottoCount)

        printLottoInfo(lottoCount, purchasedLottos)

        val winningNumbers = inputWinningNumbers()
        val bonusNumber = inputBonusNumber()

        val results = calculateResults(purchasedLottos, winningNumbers, bonusNumber)
        val profitRate = calculateProfitRate(results, purchaseAmount)

        printResults(results, profitRate)
    }

    private fun generateLottos(count: Int): List<Lotto> {
        return List(count) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            Lotto(numbers)
        }
    }

    private fun calculateProfitRate(results: Map<Prize, Int>, purchaseAmount: Int): Double {
        val totalPrizeMoney = results.entries.sumOf { (prize, count) -> prize.prizeMoney * count }
        return (totalPrizeMoney / purchaseAmount.toDouble()) * 100
    }
}