package lotto.domain

class Purchase(
    private val inputAmount: String,
) {
    private val _amount: Int
    val amount: Int
        get() = _amount

    private val _lottoCount: Int
    val lottoCount: Int
        get() = _lottoCount

    init {
        val rawAmount = parseAmount()
        validAmount(rawAmount)
        _amount = rawAmount
        _lottoCount = calculateLottoCount(rawAmount)
    }

    private fun parseAmount() =
        inputAmount.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 구매금액은 숫자를 입력해야 합니다.")

    private fun validAmount(rawAmount: Int) {
        validatePositive(rawAmount)
        validateThousandUnit(rawAmount)
    }

    private fun validatePositive(amount: Int) =
        require(amount > 0) { "[ERROR] 구매금액은 양수를 입력해야 합니다." }

    private fun validateThousandUnit(amount: Int) =
        require(amount % 1000 == 0) { "[ERROR] 구매금액은 1,000원 단위로 입력해야 합니다." }

    private fun calculateLottoCount(amount: Int): Int = amount / 1000

}
