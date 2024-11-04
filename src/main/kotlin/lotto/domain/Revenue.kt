package lotto.domain

class Revenue(
    private val purchaseAmount: Int,
    private val totalPrize: Long,
) {

    init {
        validatePurchaseAmount(purchaseAmount)
        validateTotalPrize(totalPrize)
    }

    fun getRevenueRate(): Double {
        val totalPrize = totalPrize.toDouble()
        val totalCost = purchaseAmount.toDouble()
        val revenueRate = calculateRevenueRate(totalPrize, totalCost)
        return revenueRate
    }

    private fun calculateRevenueRate(totalPrize: Double, totalCost: Double) =
        (totalPrize / totalCost) * PERCENTAGE

    private fun validatePurchaseAmount(purchaseAmount: Int) {
        validateAmountPositive(purchaseAmount)
        validateThousandUnit(purchaseAmount)
    }

    private fun validateAmountPositive(amount: Int) =
        require(amount > ZERO) { AMOUNT_POSITIVE_ERROR_MESSAGE }

    private fun validateThousandUnit(amount: Int) =
        require(amount % CURRENCY_UNIT == ZERO) { THOUSAND_UNIT_ERROR_MESSAGE }

    private fun validateTotalPrize(totalPrize: Long) =
        require(totalPrize >= ZERO) { TOTAL_PRIZE_ERROR_MESSAGE }

    companion object {
        private const val AMOUNT_POSITIVE_ERROR_MESSAGE = "구매금액은 양수를 입력해야 합니다."
        private const val THOUSAND_UNIT_ERROR_MESSAGE = "구매금액은 1,000원 단위로 입력해야 합니다."
        private const val TOTAL_PRIZE_ERROR_MESSAGE = "당첨금액은 음수 일 수 없습니다."
        private const val CURRENCY_UNIT = 1000
        private const val PERCENTAGE = 100
        private const val ZERO = 0
    }
}
