package lotto

import camp.nextstep.edu.missionutils.Console

class PurchaseAmount {
    init {
        purchaseAmountMessage()
    }

    private var validatorTest = false
    private var amount = ""

    fun lottoPurchased(): Int {
        while (!validatorTest) {
            purchaseAmountException()
        }
        return amount.toInt()
    }


    private fun purchaseAmountException(): Any {
        try {
            amount = purchaseAmountInput()
            checkBlank(amount)
            checkNumber(amount)
            checkDivide(amount)
            validatorTest = true
            return amount
        } catch (ex: Exception) {
            return println(ex.message)
        }
    }

    private fun purchaseAmountInput(): String {
        return Console.readLine()
    }

//    private fun validateAmount(amount: String): Int {
//        checkBlank(amount)
//        checkNumber(amount)
//        checkDivide(amount)
//        return amount.toInt()
//    }

    private fun checkBlank(amount: String) {
        require(amount.isNotBlank()) { ExceptionMessage.BLANK }
    }

    private fun checkNumber(amount: String) {
        require(amount.contains(Regex("^[0-9]*$"))) { ExceptionMessage.NOT_NUMBERS }
    }

    private fun checkDivide(amount: String) {
        require(amount.toInt() % 1000 == 0) { ExceptionMessage.NOT_DIVIDE_THOUSAND }
    }


    private fun purchaseAmountMessage() {
        return println(Message.ENTER_PURCHASE_AMOUNT)
    }
}