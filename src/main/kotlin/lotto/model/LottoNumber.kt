package lotto.model

import lotto.util.ErrorMessage

@JvmInline
value class LottoNumber(val number: Int) {
    init {
        validateLottoNumber(number)
    }

    private fun validateLottoNumber(number: Int) {
        require(number in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) {
            ErrorMessage.LOTTO_RANGE.getMessage()
        }
    }

    companion object {
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
    }
}
