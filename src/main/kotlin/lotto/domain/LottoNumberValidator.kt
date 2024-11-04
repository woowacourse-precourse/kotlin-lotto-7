package lotto.domain

object LottoNumberValidator {
    fun validate(number: Int) {
        validateRange(number)
    }

    private fun validateRange(number: Int) {
        require(number in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) { ERROR_INVALID_RANGE_MESSAGE }
    }

    private const val ERROR_INVALID_RANGE_MESSAGE = "[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다."
    private const val MIN_LOTTO_NUMBER = 1
    private const val MAX_LOTTO_NUMBER = 45
}