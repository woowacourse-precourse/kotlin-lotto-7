package lotto

import kotlin.math.round

class TotalLottoResult(
    private val purchasedLotto: PurchasedLotto,
    private val winningNumbers: WinningNumbers,
    private val bonusNumber: BonusNumber
) {
    val winningStatus = mutableMapOf(1 to 0, 2 to 0, 3 to 0, 4 to 0, 5 to 0)
    val rank = mapOf(1 to WinnerRank.FIRST, 2 to WinnerRank.SECOND, 3 to WinnerRank.THIRD, 4 to WinnerRank.FOURTH, 5 to WinnerRank.FIFTH)

    init {
        checkAllLotto()
        calculateRateOfReturn()
    }

    fun checkAllLotto() {
        purchasedLotto.purchasedLotto.forEach {
            val rank = Lotto(it).checkRank(winningNumbers, bonusNumber)

            if (rank > 0) {
                winningStatus[rank] = winningStatus[rank]!! + 1
            }
        }
    }

    fun calculateRateOfReturn(): Float {
        val payment = purchasedLotto.amountOfLotto * 1000
        var totalPrize = 0

        winningStatus.forEach {
            totalPrize += rank[it.key]!!.prize * it.value
        }
        return totalPrize.toFloat() / payment * 100
    }
}