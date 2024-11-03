package lotto

class PurchaseAmount(private val amount: Int, private val ticketPrice: Int) {
    init {
        require(amount > 0) { "[ERROR] 구입금액은 양수여야 합니다." }
        require(amount % ticketPrice == 0) { "[ERROR] 구입금액은 ${ticketPrice}원 단위여야 합니다." }
    }
}