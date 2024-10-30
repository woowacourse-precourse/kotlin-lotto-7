package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    private val validator = Validator()

    fun amountTickets(): Int {
        val payment = inputPayment()
        require(payment % LOTTO_PRICE == REMAINDER_AFTER_DIVIDE) { ERROR_PAYMENT_UNIT }
        return (payment / LOTTO_PRICE).toInt()
    }

    private fun inputPayment(): Long {
        val payment = Console.readLine()
        return validator.validatePayment(payment)
    }

    companion object {
        private const val ERROR_PAYMENT_UNIT = "[ERROR] 구매 금액은 1000원 단위여야 합니다."
        private const val LOTTO_PRICE = 1000L
        private const val REMAINDER_AFTER_DIVIDE = 0L
    }
}