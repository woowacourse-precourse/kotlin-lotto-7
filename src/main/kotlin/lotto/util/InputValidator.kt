package lotto.util

class InputValidator {

    fun validatePurchaseAmount(purchaseAmount: String) {
        val parsedPurchaseAmount = purchaseAmount.toIntOrNull()

        require(parsedPurchaseAmount != null) {
            ErrorMessages.INVALID_PURCHASE_AMOUNT_FORMAT
        }
        require(parsedPurchaseAmount >= 1000 && parsedPurchaseAmount % 1000 == 0) {
            ErrorMessages.INVALID_PURCHASE_AMOUNT_UNIT
        }
    }

    fun validateWinningNumbers(winningNumbers: List<Int?>) {
        require(winningNumbers.all { it != null }) {
            ErrorMessages.INVALID_WINNING_NUMBERS_FORMAT
        }
        require(winningNumbers.size == 6) {
            ErrorMessages.INVALID_WINNING_NUMBERS_SIZE
        }
        require(winningNumbers.all { it!! > 0 && it <= 45 }) {
            ErrorMessages.INVALID_WINNING_NUMBERS_RANGE
        }
        require(winningNumbers.size == winningNumbers.distinct().size) {
            ErrorMessages.DUPLICATE_WINNING_NUMBERS
        }
    }

}