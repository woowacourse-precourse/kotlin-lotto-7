package lotto.model

private const val TICKET_PRICE = 1_000

class PurchaseAmount(purchaseAmount: Int) {
    init {
        require(purchaseAmount >= TICKET_PRICE) { "구입 단위는 ${TICKET_PRICE}원 이상이어야 합니다." }
    }
}
