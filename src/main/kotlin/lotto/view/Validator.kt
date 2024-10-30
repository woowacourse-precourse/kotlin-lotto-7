package lotto.view

class Validator {
    fun validatePayment(payment: String): Int {
        try {
            val convertPayment = payment.toInt()
            require(convertPayment >= LOWER_RANGE_PAYMENT) { ERROR_POSITIVE_DIGIT }
            require(convertPayment <= UPPER_RANGE_PAYMENT) { ERROR_MAX_PAYMENT }
            return convertPayment
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ERROR_ONLY_LONG_DIGIT)
        }
    }

    fun validatePrizeNumber(numbers: List<String>): List<Int> {
        try {
            val convertNumbers = numbers.mapNotNull { it.toIntOrNull() }
            Lotto(convertNumbers)
            return convertNumbers
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ERROR_ONLY_DIGIT)
        }
    }

    fun validateBonusNumber(number: String): Int {
        try {
            val convertNumber = number.toInt()
            require(convertNumber in LOWER_RANGE_LOTTO_NUMBER..UPPER_RANGE_LOTTO_NUMBER) { ERROR_RANGE_NUMBER }
            return convertNumber
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ERROR_ONLY_DIGIT)
        }
    }

    companion object {
        private const val ERROR_POSITIVE_DIGIT = "[ERROR] 구매 금액은 양수여야 합니다."
        private const val ERROR_MAX_PAYMENT = "[ERROR] 구매 금액은 2,000,000,000 이하여야 합니다."
        private const val ERROR_ONLY_LONG_DIGIT = "[ERROR] 구매 금액은 int 범위 내의 숫자여야 합니다."
        private const val ERROR_RANGE_NUMBER = "[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다."
        private const val ERROR_ONLY_DIGIT = "[ERROR] 숫자만 입력 가능합니다."
        private const val LOWER_RANGE_PAYMENT = 0
        private const val UPPER_RANGE_PAYMENT = 2000000000
        private const val LOWER_RANGE_LOTTO_NUMBER = 1
        private const val UPPER_RANGE_LOTTO_NUMBER = 45
    }
}