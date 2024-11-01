package lotto.model

import lotto.util.ExceptionConstants.ERROR_MESSAGE_PURCHASE_AMOUNT_LESS_THAN_MINIMUM
import lotto.util.ExceptionConstants.ERROR_MESSAGE_PURCHASE_AMOUNT_NOT_MULTIPLE
import lotto.util.ExceptionConstants.ERROR_MESSAGE_PURCHASE_AMOUNT_TYPE

class PurchaseAmount(private var purchaseAmount: Int = 0) {

    fun getPurchaseAmount(): Int = purchaseAmount

    fun setPurchaseAmount(rawPurchaseAmount: String) {
        validatePurchaseAmount(rawPurchaseAmount)
        purchaseAmount = rawPurchaseAmount.toInt()
    }

    private fun validatePurchaseAmount(rawPurchaseAmount: String) {
        require(rawPurchaseAmount.toIntOrNull() != null) { ERROR_MESSAGE_PURCHASE_AMOUNT_TYPE }
        require(rawPurchaseAmount.toInt() >= 1000) { ERROR_MESSAGE_PURCHASE_AMOUNT_LESS_THAN_MINIMUM }
        require(rawPurchaseAmount.toInt() % 1000 == 0) { ERROR_MESSAGE_PURCHASE_AMOUNT_NOT_MULTIPLE }
    }
}
