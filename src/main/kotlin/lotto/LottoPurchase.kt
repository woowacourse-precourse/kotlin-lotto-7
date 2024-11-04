package lotto

class LottoPurchase(private val amount: Int) {
    init {
        require(amount % 1000 == 0) { "[ERROR] 구입 금액은 1,000원 단위여야 합니다." }
        require(amount > 0) { "[ERROR] 구입 금액은 0보다 커야 합니다." }
    }

    fun getTicketCount(): Int {
        return amount / 1000
    }
}
