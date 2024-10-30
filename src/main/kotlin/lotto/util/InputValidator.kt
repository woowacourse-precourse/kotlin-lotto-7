package lotto.util

class InputValidator {

    fun validatePurchaseAmount(purchaseAmount: String) {
        val parsedPurchaseAmount = purchaseAmount.toIntOrNull()

        require(parsedPurchaseAmount != null) {
            Messages.INVALID_PURCHASE_AMOUNT_FORMAT
        }
        require(parsedPurchaseAmount >= 1000 && parsedPurchaseAmount % 1000 == 0) {
            Messages.INVALID_PURCHASE_AMOUNT_UNIT
        }
    }

}