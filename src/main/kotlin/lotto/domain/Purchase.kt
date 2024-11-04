package lotto.domain

class Purchase(
    private val inputAmount: String,
) {
    private val _amount: Int
    val amount: Int
        get() = _amount

    init {
        val rawAmount = parseAmount()
        validateAmount(rawAmount)
        _amount = rawAmount
    }

    fun getLottoCount(): Int {
        val lottoCount = calculateLottoCount(amount)
        return lottoCount
    }

    private fun calculateLottoCount(amount: Int): Int = amount / CURRENCY_UNIT

    private fun parseAmount() =
        inputAmount.toIntOrNull() ?: throw IllegalArgumentException(PARSE_AMOUNT_ERROR_MESSAGE)

    private fun validateAmount(rawAmount: Int) {
        validateAmountPositive(rawAmount)
        validateThousandUnit(rawAmount)
    }

    private fun validateAmountPositive(amount: Int) =
        require(amount > ZERO) { AMOUNT_POSITIVE_ERROR_MESSAGE }

    private fun validateThousandUnit(amount: Int) =
        require(amount % CURRENCY_UNIT == ZERO) { THOUSAND_UNIT_ERROR_MESSAGE }

    companion object {
        private const val PARSE_AMOUNT_ERROR_MESSAGE = "구매금액은 숫자를 입력해야 합니다."
        private const val AMOUNT_POSITIVE_ERROR_MESSAGE = "구매금액은 양수를 입력해야 합니다."
        private const val THOUSAND_UNIT_ERROR_MESSAGE = "구매금액은 1,000원 단위로 입력해야 합니다."
        private const val CURRENCY_UNIT = 1000
        private const val ZERO = 0
    }

}
