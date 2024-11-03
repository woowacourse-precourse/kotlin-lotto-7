package lotto.model

class PurchaseAmount(private val amount: Int) {
    init {
        require (amount % PURCHASE_UNIT == 0) { "[ERROR] 구매 금액은 ${PURCHASE_UNIT}원 단위로 입력 해야 합니다." }
        require (amount > 0) { "[ERROR] 구매 금액은 양수로 입력 해야 합니다."}
    }

    fun calculatePurchaseQuantity() = amount / PURCHASE_UNIT

    companion object {
        private const val PURCHASE_UNIT = 1000
    }
}