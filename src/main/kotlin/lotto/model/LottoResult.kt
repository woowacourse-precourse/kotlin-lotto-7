package lotto.model

import lotto.util.Constants

data class LottoResult(
    val prizeCounts: Map<Prize, Int>,
    val totalPrize: Int,
    val purchaseAmount: Int
) {
    val profitRate: Double
        get() {
            if (purchaseAmount > 0) {
                return (totalPrize.toDouble() / purchaseAmount * Constants.PERCENTAGE_MULTIPLIER)
                    .roundToTwoDecimalPlaces()
            }
            return 0.0
        }

    private fun Double.roundToTwoDecimalPlaces(): Double {
        return String.format("%.2f", this).toDouble()
    }
}