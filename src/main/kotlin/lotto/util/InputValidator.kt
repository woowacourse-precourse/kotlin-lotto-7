package lotto.util

object InputValidator {
    fun validateInputIsNumeric(input: String) {
        if (input.toIntOrNull() == null) throw IllegalArgumentException(ErrorMessage.INPUT_NOT_NUMERIC)
    }

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
