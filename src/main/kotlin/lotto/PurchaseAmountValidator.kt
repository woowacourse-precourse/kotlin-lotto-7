package lotto

import view.Input

class PurchaseAmountValidator {

    private var validatorTest = false
    private var amount = ""

    fun validate(): Int {
        while (!validatorTest) {
            purchaseAmountException()
        }
        return amount.toInt()
    }

    private fun purchaseAmountException(): Any {
        try {
            amount = Input().purchaseAmountInput()
            checkBlank(amount)
            checkNumber(amount)
            checkDivide(amount)
            validatorTest = true
            return amount
        } catch (ex: Exception) {
            return println(ex.message)
        }
    }

    private fun checkBlank(amount: String) {
        require(amount.isNotBlank()) { ErrorList.BLANK }
    }

    private fun checkNumber(amount: String) {
        require(amount.contains(Regex("^[0-9]*$"))) { ErrorList.NOT_NUMBERS }
    }

    private fun checkDivide(amount: String) {
        require(amount.toInt() % 1000 == 0 && amount.toInt() != 0) { ErrorList.NOT_DIVIDE_THOUSAND }
    }
}