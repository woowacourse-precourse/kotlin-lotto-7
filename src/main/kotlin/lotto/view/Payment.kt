package lotto.view

import lotto.util.ErrorMessages

class Payment(private val payment: Int) {
    init {
        validatePayment()
    }

    private fun validatePayment() {
        require(payment > LOWER_RANGE_PAYMENT) {
            ErrorMessages.ERROR_POSITIVE_DIGIT.message
        }
        require(payment <= UPPER_RANGE_PAYMENT) {
            ErrorMessages.ERROR_MAX_PAYMENT.message
        }
        require(payment % LOTTO_PRICE == REMAINDER) {
            ErrorMessages.ERROR_PAYMENT_UNIT.message
        }
    }

    companion object {
        private const val LOWER_RANGE_PAYMENT = 0
        private const val UPPER_RANGE_PAYMENT = 2000000000
        private const val LOTTO_PRICE = 1000
        private const val REMAINDER = 0
    }
}