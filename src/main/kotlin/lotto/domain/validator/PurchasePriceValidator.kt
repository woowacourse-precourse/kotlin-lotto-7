package lotto.domain.validator

import lotto.common.LOTTO_PRICE

class PurchasePriceValidator : LottoNumberValidator() {
    fun validateMoney(money: Int) {
        validateMultipleOfThousand(money)
        validateUnderMinMoney(money)
    }

    private fun validateMultipleOfThousand(money: Int) {
        require(money.rem(LOTTO_PRICE) == REMAINDER_ZERO) { ERROR_MULTIPLE_OF_THOUSAND }
    }

    private fun validateUnderMinMoney(money: Int) {
        require(money >= MIN_MONEY) { ERROR_NON_NEGATIVE }
    }

    companion object {
        private const val REMAINDER_ZERO = 0
        private const val ERROR_MULTIPLE_OF_THOUSAND = "[ERROR] 돈은 1000원에 배수여야 합니다."
        private const val MIN_MONEY = 1000
        private const val ERROR_NON_NEGATIVE = "[ERROR] 돈은 1000보다 같거나 커야 합니다."
    }
}