package lotto.domain.validator

class PurchasePriceValidator : NumberValidator() {
    fun validateMoney(money: Int) {
        validateMultipleOfThousand(money)
        validateNonNegative(money)
    }

    private fun validateMultipleOfThousand(money: Int) {
        require(money.rem(1000) == 0) { "[ERROR] 돈은 1000원에 배수여야 합니다." }
    }

    private fun validateNonNegative(money: Int) {
        require(money >= 0) { "[ERROR] 돈은 0보다 같거나 커야 합니다." }
    }
}