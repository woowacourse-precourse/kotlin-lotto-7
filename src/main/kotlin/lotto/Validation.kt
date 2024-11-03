package lotto

object Validation {
    fun parseAmount(amount: String?): Int {
        if (amount.isNullOrEmpty()) throw LottoError.INVALID_AMOUNT.throwException()
        return amount.toIntOrNull() ?: throw LottoError.INVALID_AMOUNT.throwException()
    }

    fun validateAmount(amount: Int) {
        if (amount <= 0) throw LottoError.INVALID_AMOUNT.throwException()
        if (amount % 1000 != 0) throw LottoError.INVALID_UNIT.throwException()
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

    fun validateBonusNumber(input: String?, winningNumbers: List<Int>): Int {
        if (input.isNullOrBlank()) throw LottoError.INVALID_NUM.throwException()

        val bonusNum = input.trim().toIntOrNull()
        if (bonusNum == null || bonusNum < 1 || bonusNum > 45)
            throw LottoError.INVALID_NUM.throwException()

        if (winningNumbers.contains(bonusNum)) throw LottoError.INVALID_DUPLICATE.throwException()

        return bonusNum
    }
}