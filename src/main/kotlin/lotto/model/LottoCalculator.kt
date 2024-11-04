package lotto.model

import lotto.model.Lotto.Companion.LOTTO_PRICE

class LottoCalculator {

    fun calculateLottoCount(amount: Int): Int {
        return amount / LOTTO_PRICE
    }

    fun calculateStatistics(purchasedLottos: List<Lotto>, winningLotto: WinningLotto): List<LottoPrize> {
        return purchasedLottos.map { it.compareWinningLotto(winningLotto) }
    }

    fun calculateYield(prizes: List<LottoPrize>, amount: Int): Double {
        val totalPrizeMoney = prizes.sumOf { it.price }
        return (totalPrizeMoney.toDouble() / amount) * PERCENTAGE
    }

    companion object {
        private const val PERCENTAGE = 100
    }
}