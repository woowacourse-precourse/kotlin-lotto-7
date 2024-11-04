package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.ErrorMessages

class InputView {
    fun amountTickets(): Int {
        while (true) {
            try {
                val payment = inputPayment()
                return payment / LOTTO_PRICE
            } catch (error: IllegalArgumentException) {
                println(error.message)
            }
        }
    }

    private fun inputPayment(): Int {
        val payment = Console.readLine()
        try {
            val convertPayment = payment.toInt()
            Payment(convertPayment)
            return convertPayment
        } catch (error: NumberFormatException) {
            throw IllegalArgumentException(ErrorMessages.ERROR_MAX_PAYMENT.message)
        }
    }

    fun getPrizeNumber(): List<Int> {
        while (true) {
            try {
                val prizeNumber = inputPrizeNumber()
                Lotto(prizeNumber)
                return prizeNumber
            } catch (error: IllegalArgumentException) {
                println(error.message)
            }
        }
    }

    private fun inputPrizeNumber(): List<Int> {
        try {
            val prizeNumber = Console.readLine()
            val numbers = prizeNumber.split(NUMBER_DELIMITER)
            val convertNumbers = numbers.mapNotNull { it.toIntOrNull() }
            return convertNumbers
        } catch (error: IllegalArgumentException) {
            throw IllegalArgumentException(ErrorMessages.ERROR_ONLY_DIGIT.message)
        }
    }

    fun getBonusNumber(): Int {
        while (true) {
            try {
                val bonusNumber = inputBonusNumber()
                Bonus(bonusNumber)
                return bonusNumber
            } catch (error: IllegalArgumentException) {
                println(error.message)
            }
        }
    }

    private fun inputBonusNumber(): Int {
        while (true) {
            try {
                val number = Console.readLine()
                val convertNumber = number.toInt()
                Bonus(convertNumber)
                return convertNumber
            } catch (error: IllegalArgumentException) {
                throw IllegalArgumentException(ErrorMessages.ERROR_ONLY_DIGIT.message)
            }
        }
    }

    companion object {
        private const val LOTTO_PRICE = 1000
        private const val NUMBER_DELIMITER = ","
    }
}