package lotto

object Validator {
    fun checkPurchaseAmount(purchaseAmount: String) {
        require(purchaseAmount.toIntOrNull() == null) { "[ERROR] 1" }
        require(purchaseAmount==""){"[ERROR] 2"}
    }
}