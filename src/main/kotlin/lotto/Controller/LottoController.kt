package lotto.Controller

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
}