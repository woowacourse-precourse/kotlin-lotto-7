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

    companion object {
        private const val ERROR_POSITIVE_DIGIT = "[ERROR] 구매 금액은 양수여야 합니다."
        private const val ERROR_MAX_PAYMENT = "[ERROR] 구매 금액은 2,000,000,000 이하여야 합니다."
        private const val ERROR_ONLY_LONG_DIGIT = "[ERROR] 구매 금액은 int 범위 내의 숫자여야 합니다."
        private const val LOWER_RANGE_PAYMENT = 0
        private const val UPPER_RANGE_PAYMENT = 2000000000
    }
}