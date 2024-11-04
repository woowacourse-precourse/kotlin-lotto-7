package lotto.data

class PurchaseAmount(private val amount: String, private val ticketPrice: Int) {
    init {
        require(amount.toIntOrNull() != null) { "[ERROR] 구입금액은 정수여야 합니다." }
        require(amount.toInt() > 0) { "[ERROR] 구입금액은 양수여야 합니다." }
        require(amount.toInt() % ticketPrice == 0) { "[ERROR] 구입금액은 ${ticketPrice}원 단위여야 합니다." }
    }

    fun getAmount(): Int = amount.toInt()
}