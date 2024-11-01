package lotto

class Validation {
    fun checkPayment(payment: String): Int {

        if (isDigit(payment)) {
            val convertedPayment = payment.toInt()

            when {
                !isPaymentUnit1000(convertedPayment) -> throw IllegalArgumentException()
            }

            if (isPaymentUnder100000(convertedPayment) && (isPaymentUnit1000(convertedPayment))) {
                return convertedPayment
            }
        }
        throw IllegalArgumentException()
    }

    fun isDigit(input: String): Boolean {
        input.forEach {
            if (!it.isDigit()) {
                return false
            }
        }
        return true
    }

    fun isPaymentUnder100000(payment: Int): Boolean {
        return payment in 0..100000
    }

    fun isPaymentUnit1000(payment: Int): Boolean {
        return payment % 1000 == 0
    }
}

class Exception {
    fun showError() {
        throw IllegalArgumentException()
    }
}