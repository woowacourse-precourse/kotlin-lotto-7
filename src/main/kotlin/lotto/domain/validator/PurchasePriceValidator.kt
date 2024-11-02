package lotto.domain.validator

import lotto.common.LOTTO_PRICE

class PurchasePriceValidator : NumberValidator() {
    fun validateMoney(money: Int) {
        validateMultipleOfThousand(money)
        validateNonNegative(money)
    }

    private fun validateMultipleOfThousand(money: Int) {
        require(money.rem(LOTTO_PRICE) == REMAINDER_ZERO) { "[ERROR] 돈은 1000원에 배수여야 합니다." }
    }

    private fun validateNonNegative(money: Int) {
        require(money >= MIN_MONEY) { "[ERROR] 돈은 0보다 같거나 커야 합니다." }
    }

    companion object {
        private const val REMAINDER_ZERO = 0
        private const val MIN_MONEY = 0
    }
}