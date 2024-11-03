package lotto.domain

import lotto.domain.Lotto.Companion.PRICE

class LottoOperator(
    private val winningLottos: List<Lotto>, private val purchasedLotto: Lotto, private val bonusNumber: Int
) {
    fun checkLotteryResult(): List<LottoResult> {
        return winningLottos.map { winningLotto ->
            val matchedNumbersCount = countMatchedNumbers(winningLotto)
            val bonusMatched = bonusMatched(winningLotto)
            LottoResult.of(matchedNumbersCount, bonusMatched)
        }
    }

    private fun countMatchedNumbers(winningLotto: Lotto): Int {
        return purchasedLotto.getNumbers().count { number -> number in winningLotto.getNumbers() }
    }

    private fun bonusMatched(winningLotto: Lotto): Boolean {
        return bonusNumber in winningLotto.getNumbers()
    }

    companion object {
        fun buy(purchasePrice: Int): List<Lotto> {
            return (1..purchasePrice / PRICE).map { Lotto.generate() }
        }
    }
}
