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
    }

    companion object {
        private const val LOWER_RANGE_PAYMENT = 0
        private const val UPPER_RANGE_PAYMENT = 2000000000
    }
}