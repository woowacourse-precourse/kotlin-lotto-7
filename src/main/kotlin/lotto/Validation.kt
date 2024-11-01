package lotto

class Validation {
    fun checkPayment(payment: String): Int {
        require(isDigit(payment)) { PAYMENTNOTDIGITINSTRUCTION }

        val convertedPayment = payment.toInt()

        require(isPaymentUnder100000(convertedPayment)) { PAYMENTOVERLIMITINSTRUCTION }
        require(isPaymentUnit1000(convertedPayment)) { PAYMENTNOT1000INSTRUCTION }
        return convertedPayment
    }

    fun isDigit(input: String): Boolean {
        input.forEach {
            if (!it.isDigit()) {
                return false
            }
        }
        return true
    }

    private fun isPaymentUnder100000(payment: Int): Boolean {
        return payment in 0..PURCHASELIMIT
    }

    private fun isPaymentUnit1000(payment: Int): Boolean {
        return payment % SALEUNIT == 0
    }

    companion object {
        const val PURCHASELIMIT = 100000
        const val SALEUNIT = 1000
        const val PAYMENTNOTDIGITINSTRUCTION = "[ERROR] 구입금액은 숫자로 입력해야 합니다."
        const val PAYMENTOVERLIMITINSTRUCTION = "[ERROR] 10만원 구입 한도를 초과하였습니다."
        const val PAYMENTNOT1000INSTRUCTION = "[ERROR] 구입금액은 1000원 단위로 입력해야 합니다. 로또 1장의 가격은 1000원입니다."
    }
}