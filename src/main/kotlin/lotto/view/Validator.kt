package lotto.view

class Validator {
    fun validatePayment(payment: String): Int {
        try {
            val convertPayment = payment.toInt()
            require(convertPayment >= LOWER_RANGE_PAYMENT) { ErrorMessages.ERROR_POSITIVE_DIGIT.message }
            require(convertPayment <= UPPER_RANGE_PAYMENT) { ErrorMessages.ERROR_MAX_PAYMENT.message }
            return convertPayment
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ErrorMessages.ERROR_ONLY_LONG_DIGIT.message)
        }
    }

    fun validatePrizeNumber(numbers: List<String>): List<Int> {
        try {
            val convertNumbers = numbers.mapNotNull { it.toIntOrNull() }
            Lotto(convertNumbers)
            return convertNumbers
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ErrorMessages.ERROR_ONLY_DIGIT.message)
        }
    }

    fun validateBonusNumber(number: String): Int {
        try {
            val convertNumber = number.toInt()
            require(convertNumber in LOWER_RANGE_LOTTO_NUMBER..UPPER_RANGE_LOTTO_NUMBER) {
                ErrorMessages.ERROR_RANGE_NUMBER.message
            }
            return convertNumber
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ErrorMessages.ERROR_ONLY_DIGIT.message)
        }
    }

    companion object {
        private const val LOWER_RANGE_PAYMENT = 0
        private const val UPPER_RANGE_PAYMENT = 2000000000
        private const val LOWER_RANGE_LOTTO_NUMBER = 1
        private const val UPPER_RANGE_LOTTO_NUMBER = 45
    }
}