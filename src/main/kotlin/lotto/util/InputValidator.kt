package lotto.util

object InputValidator {
    fun validateInputIsNumeric(input: String) {
        if (input.toIntOrNull() == null) throw IllegalArgumentException(ErrorMessage.ERROR_INPUT_NOT_NUMERIC)
    }

    fun validateMoneyIsDivisible(lottoMoney: Int) {
        if (lottoMoney % Constant.LOTTO_PRICE != 0) throw IllegalArgumentException(ErrorMessage.ERROR_MONEY_NOT_DIVISIBLE)
    }
}
