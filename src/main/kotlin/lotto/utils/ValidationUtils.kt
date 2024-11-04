package lotto.utils

import lotto.model.message.ErrorMessage

object ValidationUtils {
    fun validatePurchaseAmount(amount: Int) {
        require(amount % 1000 == 0) { ErrorMessage.PURCHASE_PRICE_1000.message }
    }

    fun validateWinningNumberInput(input: String?): Int {
        require(!input.isNullOrEmpty()) { ErrorMessage.INPUT_WINNING_EMPTY.message }
        return input.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.message)
    }

    fun validateNumberInput(input: String?): Int {
        return input?.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.message)
    }
}
