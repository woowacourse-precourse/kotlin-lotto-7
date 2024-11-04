package lotto.model

import lotto.util.ErrorMessage

@JvmInline
value class Money(val amount: Int) {
    init {
        validateAmount(amount)
    }

    fun getLottoCount(): Int = amount / LOTTO_PRICE

    private fun validateAmount(amount: Int) {
        validateAmountValue(amount)
        validateAmountUnit(amount)
    }

    private fun validateAmountValue(amount: Int) {
        require(amount >= LOTTO_PRICE) {
            ErrorMessage.AMOUNT_VALUE.getMessage()
        }
    }

    private fun validateAmountUnit(amount: Int) {
        require(amount % LOTTO_PRICE == 0) {
            ErrorMessage.AMOUNT_UNIT.getMessage()
        }
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
