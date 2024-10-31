package lotto

import camp.nextstep.edu.missionutils.Console

class PurchaseAmount {
    init {
        purchaseAmountMessage()
    }

    fun price() = validateAmount(purchaseAmountInput())

    private fun purchaseAmountInput(): String {
        return Console.readLine()
    }

    private fun validateAmount(userInput: String): Int {
        if (userInput.isBlank()) {
            throw IllegalArgumentException(ExceptionMessage.BLANK)
        }
        if (!userInput.contains(Regex("^[0-9]*$"))) {
            throw IllegalArgumentException(ExceptionMessage.NOT_NUMBERS)
        }
        if (userInput.toInt() % 1000 != 0) {
            throw IllegalArgumentException(ExceptionMessage.NOT_DIVIDE_THOUSAND)
        }
        return userInput.toInt()
    }

    private fun purchaseAmountMessage() {
        return println(Message.ENTER_PURCHASE_AMOUNT)
    }
}