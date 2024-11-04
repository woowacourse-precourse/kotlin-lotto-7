package lotto

enum class LottoError(val message: String) {
    INVALID_AMOUNT("[ERROR] 유효한 금액을 입력해주세요."),
    INVALID_UNIT("[ERROR] 로또 금액은 1000원 단위로 입력해야 합니다."),
    INVALID_NUM("[ERROR] 1~45 사이의 중복되지 않는 6개의 숫자를 입력해 주세요."),
    INVALID_SPLIT("[ERROR] 유효한 구분자와 숫자를 사용해 주세요."),
    INVALID_DUPLICATE("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    fun throwException(): IllegalArgumentException {
        return IllegalArgumentException(this.message)
    }
}

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