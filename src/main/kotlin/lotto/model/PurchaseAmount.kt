package lotto.model

class PurchaseAmount(private val amount: Int) {
    init {
        require (amount % PURCHASE_UNIT == 0) { INPUT_PURCHASE_UNIT_ERROR }
        require (amount > 0) { INPUT_PURCHASE_AMOUNT_POSITIVE_NUMBER_ERROR }
    }

    fun calculatePurchaseQuantity() = amount / PURCHASE_UNIT

    fun getPurchaseAmount() = amount

    companion object {
        private const val PURCHASE_UNIT = 1000
        private const val ERROR_MESSAGE = "[ERROR]"
        private const val INPUT_PURCHASE_UNIT_ERROR = "$ERROR_MESSAGE 구매 금액은 ${PURCHASE_UNIT}원 단위로 입력 해야 합니다. "
        private const val INPUT_PURCHASE_AMOUNT_POSITIVE_NUMBER_ERROR = "$ERROR_MESSAGE 구매 금액은 양수로 입력 해야 합니다."
    }
}