package lotto.model

class LottoCalculator {

    fun calculateLottoCount(amount: Int): Int {
        return amount / 1_000
    }

    fun calculateStatistics(purchasedLottos: List<Lotto>, winningLotto: WinningLotto): List<LottoPrize> {
        return purchasedLottos.map { it.compareWinningLotto(winningLotto) }
    }

    fun calculateYield(prizes: List<LottoPrize>, amount: Int): Double {
        val totalPrizeMoney = prizes.sumOf { it.price }
        return (totalPrizeMoney.toDouble() / amount) * 100
    }
}