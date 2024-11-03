package lotto.domain.usecase

import lotto.domain.model.Prize
import lotto.domain.model.PurchaseInfo

class LottoPrizeCalculator(
    private val matchResult: List<Prize>,
    private val PurchaseInfo: PurchaseInfo,
) {
    private fun calculateTotalPrize(): Int = matchResult.sumOf { it.prizeAmountValue }

    fun calculateProfitRate(): Double {
        val totalPrize = calculateTotalPrize()
        return totalPrize.toDouble() / PurchaseInfo.purchaseAmount * 100
    }
}