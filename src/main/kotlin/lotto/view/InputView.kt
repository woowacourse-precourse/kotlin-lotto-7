package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    private val validator = Validator()

    fun amountTickets(): Int {
        while (true) {
            try {
                val payment = inputPayment()
                require(payment % LOTTO_PRICE == REMAINDER_AFTER_DIVIDE) {
                    ErrorMessages.ERROR_PAYMENT_UNIT.message
                }
                return payment / LOTTO_PRICE
            } catch(error: IllegalArgumentException) {
                println(error.message)
            }
        }
    }

    private fun inputPayment(): Int {
        val payment = Console.readLine()
        return validator.validatePayment(payment)
    }

    fun inputPrizeNumber(): List<Int> {
        while (true) {
            try {
                val prizeNumber = Console.readLine()
                val numbers = prizeNumber.split(NUMBER_DELIMITER)
                val getPrizeNumber = validator.validatePrizeNumber(numbers)
                return getPrizeNumber
            } catch (error: IllegalArgumentException) {
                println(error.message)
            }
        }
    }

    fun inputBonusNumber(): Int {
        while (true) {
            try {
                val number = Console.readLine()
                return validator.validateBonusNumber(number)
            } catch (error: IllegalArgumentException) {
                println(error.message)
            }
        }
    }

    companion object {
        private const val LOTTO_PRICE = 1000
        private const val REMAINDER_AFTER_DIVIDE = 0
        private const val NUMBER_DELIMITER = ","
    }
}