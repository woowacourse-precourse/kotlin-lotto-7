package lotto.domain.model

data class PurchaseInfo(
    val purchaseAmount: Int
) {
    val numberOfTickets: Int = purchaseAmount / PRICE_PER_SHEET

    companion object {
        private const val PRICE_PER_SHEET = 1000
    }
}
