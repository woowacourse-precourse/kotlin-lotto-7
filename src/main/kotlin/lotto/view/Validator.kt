package lotto.view

class Validator {
    fun validatePayment(payment: String): Long {
        try {
            val convertPayment = payment.toLong()
            require(convertPayment in LOWER_RANGE_PAYMENT..UPPER_RANGE_PAYMENT) { ERROR_PAYMENT_SIZE }
            return convertPayment
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ERROR_ONLY_LONG_DIGIT)
        }
    }

    companion object {
        private const val ERROR_PAYMENT_SIZE = "[ERROR] 구매 금액은 0~8145060000 범위여야 합니다."
        private const val ERROR_ONLY_LONG_DIGIT = "[ERROR] 구매 금액은 Long 범위 내의 숫자여야 합니다."
        private const val LOWER_RANGE_PAYMENT = 0L
        private const val UPPER_RANGE_PAYMENT = 8145060000L
    }
}