package lotto.utils

object Validator {
    private const val ERROR_LABEL = "[ERROR]"
    private const val INVALID_PURCHASE_MONEY = "구입 금액은 숫자로 입력해야 합니다."
    private const val INVALID_PRICE_UNIT = "구입 금액은 1,000원 단위로만 가능합니다."

    fun isValidPurchaseMoney(input : String) {
        val regex = Regex("^\\d*$")
        isVallidPattern(input, regex, INVALID_PURCHASE_MONEY)

        val purchaseMoney = input.toInt()
        if( purchaseMoney < Values.MIN_PURCHASE_MONEY || purchaseMoney % Values.LOTTO_UNIT_PRICE != 0)
            throwInvalidInputException(INVALID_PRICE_UNIT)

    }


    private fun isVallidPattern(input: String, regex: Regex, errorMessage : String) {
        if(!regex.matches(input)) throwInvalidInputException(errorMessage)
    }

    private fun throwInvalidInputException(message: String) {
        throw IllegalArgumentException("$ERROR_LABEL $message")
    }
}