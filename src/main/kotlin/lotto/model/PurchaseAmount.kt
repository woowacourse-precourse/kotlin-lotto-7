package lotto.model

class PurchaseAmount(private var purchaseAmount: Int = 0) {

    fun getPurchaseAmount(): Int = purchaseAmount

    fun setPurchaseAmount(rawPurchaseAmount: String) {
        validatePurchaseAmount(rawPurchaseAmount)
        purchaseAmount = rawPurchaseAmount.toInt()
    }

    private fun validatePurchaseAmount(rawPurchaseAmount: String) {
        require(rawPurchaseAmount.toIntOrNull() != null) { NOT_NUMERIC_MESSAGE }
        require(rawPurchaseAmount.toInt() >= 1000) { LESS_THAN_MINIMUM_MESSAGE }
        require(rawPurchaseAmount.toInt() % 1000 == 0) { NOT_MULTIPLE_OF_THOUSAND_MESSAGE }
    }

    companion object {
        const val NOT_NUMERIC_MESSAGE = "구입 금액은 숫자여야 합니다."
        const val LESS_THAN_MINIMUM_MESSAGE = "구입 금액은 1,000원 이상이어야 합니다."
        const val NOT_MULTIPLE_OF_THOUSAND_MESSAGE = "구입 금액은 1,000원 단위여야 합니다."
    }
}
