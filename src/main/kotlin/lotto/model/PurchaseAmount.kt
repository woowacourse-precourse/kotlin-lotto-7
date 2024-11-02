package lotto.model

class PurchaseAmount(private val amount: Int) {
    init {
        require (amount % 1000 == 0) { "[ERROR] 구매금액은 1000원 단위로 입력해야 합니다." }
        require (amount <= 0) { "[ERROR] 구매금액은 양수로 입력해야 합니다."}
    }

    fun calculatePurchaseQuantity() = amount / 1000
}