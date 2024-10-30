package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    private val validator = Validator()

    fun amountTickets() = inputPayment().let { payment ->
        require(payment % LOTTO_PRICE == REMAINDER_AFTER_DIVIDE) {
            ErrorMessages.ERROR_PAYMENT_UNIT.message
        }
        payment / LOTTO_PRICE
    }

    private fun inputPayment() = Console.readLine().let { payment ->
        validator.validatePayment(payment)
    }

    fun inputPrizeNumber() = Console.readLine().let { prizeNumber ->
        val numbers = prizeNumber.split(NUMBER_DELIMITER)
        validator.validatePrizeNumber(numbers)
    }

    fun inputBonusNumber() = Console.readLine().let  { number ->
        validator.validateBonusNumber(number)
    }

    companion object {
        private const val LOTTO_PRICE = 1000
        private const val REMAINDER_AFTER_DIVIDE = 0
        private const val NUMBER_DELIMITER = ","
    }
}