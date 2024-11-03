package lotto.util

object InputValidator {    fun validateMoneyIsNotNegative(money: Int) {
    if (money < 0) throw IllegalArgumentException(ErrorMessage.MONEY_IS_NEGATIVE)
}

    fun validateMoneyIsEnough(money: Int) {
        if (money / Constant.LOTTO_PRICE == 0) throw IllegalArgumentException(ErrorMessage.MONEY_NOT_ENOUGH)
    }

    fun validateMoneyIsDivisible(money: Int) {
        if (money % Constant.LOTTO_PRICE != 0) throw IllegalArgumentException(ErrorMessage.MONEY_NOT_DIVISIBLE)
    }

    fun validateWinningNumbersCount(winningNumbers: List<Int>) {
        if (winningNumbers.size != Constant.LOTTO_NUMBERS_COUNT) throw IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_COUNT_MISMATCH)
    }

    fun validateWinningNumbersDistinctness(winningNumbers: List<Int>) {
        if (winningNumbers.size != winningNumbers.toSet().size) throw IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_NOT_DISTINCT)
    }

    fun validateLottoNumberInRange(number: Int) {
        if (number !in Constant.LOTTO_NUMBERS_MIN..Constant.LOTTO_NUMBERS_MAX) throw IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_NOT_IN_RANGE)
    }

    fun validateBonusNumberDistinctness(bonusNumber: Int, winningNumbers: List<Int>) {
        if (bonusNumber in winningNumbers) throw IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_NOT_DISTINCT)
    }
}
