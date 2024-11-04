package lotto.util.validator

import lotto.util.constant.ErrorMessages
import lotto.util.constant.LottoRules

object PurchaseAmountValidator {

    fun getValidatePurchaseAmount(purchaseAmountInput: String): Int {
        validatePurchaseAmount(purchaseAmountInput)
        val validatedPurchaseAmount = purchaseAmountInput.trim().toInt()
        return validatedPurchaseAmount
    }

    private fun validateNotEmpty(purchaseAmountInput: String) {
        require(purchaseAmountInput.isNotEmpty()) { ErrorMessages.AMOUNT_IS_NOT_EMPTY }
    }

    private fun validateIsNumeric(amount: Int?) {
        require(amount != null) { ErrorMessages.AMOUNT_IS_NUMERIC }
    }

    private fun validateIsMultipleOfThousand(amount: Int) {
        require(amount % LottoRules.AMOUNT_UNIT == LottoRules.ZERO) { ErrorMessages.AMOUNT_IS_MULTIPLE_OF_THOUSAND }
    }

    private fun validateMaxAmount(amount: Int) {
        require(amount in LottoRules.AMOUNT_RANGE) { ErrorMessages.OUT_OF_AMOUNT_RANGE }
    }

    fun validatePurchaseAmount(purchaseAmountInput: String) {
        validateNotEmpty(purchaseAmountInput)

        val amount = purchaseAmountInput.trim().toIntOrNull()
        validateIsNumeric(amount)
        validateIsMultipleOfThousand(amount!!)
        validateMaxAmount(amount)
    }
}