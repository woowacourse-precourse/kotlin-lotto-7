package lotto.model

class PurchaseAmount(private val purchaseAmount: Int) {
    init {
        require(purchaseAmount >= TICKET_PRICE) { "구입 금액은 ${TICKET_PRICE}원 이상이어야 합니다" }
        require(purchaseAmount % TICKET_PRICE == 0) { "구입 단위는 ${TICKET_PRICE}원 단위로 입력해야 합니다" }
    }

    fun getLottoCount(): Int {
        return purchaseAmount / TICKET_PRICE
    }

    companion object {
        private const val TICKET_PRICE = 1_000
    }
}
