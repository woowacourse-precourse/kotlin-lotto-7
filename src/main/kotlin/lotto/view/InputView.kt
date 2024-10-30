package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    private val validator = Validator()

    fun amountTickets(): Int {
        val payment = inputPayment()
        require(payment % LOTTO_PRICE == REMAINDER_AFTER_DIVIDE) { ERROR_PAYMENT_UNIT }
        return payment / LOTTO_PRICE
    }

    private fun inputPayment(): Int {
        val payment = Console.readLine()
        return validator.validatePayment(payment)
    }

    fun inputPrizeNumber(): List<Int> {
        val prizeNumber = Console.readLine()
        val numbers = prizeNumber.split(NUMBER_DELIMITER)
        return validator.validatePrizeNumber(numbers)
    }

    fun inputBonusNumber(): Int {
        val number = Console.readLine()
        return validator.validateBonusNumber(number)
    }

    companion object {
        private const val ERROR_PAYMENT_UNIT = "[ERROR] 구매 금액은 1,000원 단위여야 합니다."
        private const val LOTTO_PRICE = 1000
        private const val REMAINDER_AFTER_DIVIDE = 0
        private const val NUMBER_DELIMITER = ","
    }
}