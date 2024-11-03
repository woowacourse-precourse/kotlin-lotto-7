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

    fun validateLottoNumbers(numbers: List<Int>) {
        if (numbers.size != 6 || numbers.any { it < 1 || it > 45 } || numbers.toSet().size != numbers.size)
            throw LottoError.INVALID_NUM.throwException()
    }

    fun parseLottoNumbers(input: String?): List<Int> {
        if (input.isNullOrBlank()) throw LottoError.INVALID_AMOUNT.throwException()

        val numbers = input.split(',').map { it.trim().toIntOrNull() }
        if (numbers.any { it == null }) throw LottoError.INVALID_SPLIT.throwException()
        return numbers.filterNotNull()
    }
}