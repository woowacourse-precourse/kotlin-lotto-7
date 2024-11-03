package lotto.domain.model

import lotto.util.validator.purchaseamount.PurchaseAmountErrorType

data class PurchaseInfo(private val purchaseAmount: Int) {
    private val numberOfTickets: Int

    init {
        require(purchaseAmount >= ZERO) { PurchaseAmountErrorType.ZERO_AMOUNT.errorMessage }
        numberOfTickets = purchaseAmount / PRICE_PER_SHEET
    }

    fun getNumberOfTickets(): Int {
        return numberOfTickets
    }

    companion object {
        private const val ZERO = 0
        private const val PRICE_PER_SHEET = 1000
    }
}
