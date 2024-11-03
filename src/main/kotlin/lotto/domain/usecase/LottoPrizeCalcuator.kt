package lotto.domain.usecase

import lotto.domain.model.Prize
import lotto.domain.model.PurchaseInfo

class LottoPrizeCalcuator(
    private val matchResult: List<Prize>,
    private val PurchaseInfo: PurchaseInfo,
) {
    private fun calculateTotalPrize(): Int = matchResult.sumOf { it.prizeAmountValue }
}