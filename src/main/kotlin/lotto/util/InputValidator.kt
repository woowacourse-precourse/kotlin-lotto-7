package lotto.util

object InputValidator {
    fun validateMoneyIsNotNegative(money: Int) {
        if (money < 0) throw IllegalArgumentException(ErrorMessage.MONEY_IS_NEGATIVE)
    }

    fun validateMoneyIsEnough(money: Int) {
        if (money / Constant.LOTTO_PRICE == 0) throw IllegalArgumentException(ErrorMessage.MONEY_NOT_ENOUGH)
    }

    fun validateMoneyIsDivisible(money: Int) {
        if (money % Constant.LOTTO_PRICE != 0) throw IllegalArgumentException(ErrorMessage.MONEY_NOT_DIVISIBLE)
    }
}
