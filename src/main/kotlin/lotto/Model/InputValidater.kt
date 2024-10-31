package lotto.Model

object InputValidater {

    object ERROR{
        const val INPUT_NOT_INT = "[ERROR] 입력 값은 정수여야 합니다."
        const val INPUT_NOT_DIVIDE_1000 = "[ERROR] 입력 값은 1000으로 나누어 떨어져야 합니다."
    }

    fun validatePurchaseAmount(purchaseAmount: String) {
        if (!purchaseAmount.all { it.isDigit() }) {
            throw IllegalArgumentException(ERROR.INPUT_NOT_INT)
        }
        if (purchaseAmount.toInt() % 1000 != 0) {
            throw IllegalArgumentException(ERROR.INPUT_NOT_DIVIDE_1000)
        }
    }

    fun validateLottoNumbers(lottoNumbers: List<String>) {
        val isLottoNumbersAllDigit = lottoNumbers.all { lottoNumber ->
            lottoNumber.all { it.isDigit() }
        }
        if (!isLottoNumbersAllDigit) {
            throw IllegalArgumentException(ERROR.INPUT_NOT_INT)
        }
    }
}