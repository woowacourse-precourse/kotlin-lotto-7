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

    fun validateWinningNumbersCount(numbers: List<Int>) {
        if (numbers.size != Constant.LOTTO_NUMBER_COUNT) throw IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_COUNT_MISMATCH)
    }
}
