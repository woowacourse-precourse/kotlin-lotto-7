package lotto

object Validation {
    fun parseAmount(amount: String?): Int {
        if (amount.isNullOrEmpty()) return throw LottoError.INVALID_AMOUNT.throwException()
        return amount.toIntOrNull() ?: throw LottoError.INVALID_AMOUNT.throwException()
    }

    fun validateAmount(amount: Int) {
        if (amount <= 0) return throw LottoError.INVALID_AMOUNT.throwException()
        if (amount % 1000 != 0) return throw LottoError.INVALID_UNIT.throwException()
    }
}