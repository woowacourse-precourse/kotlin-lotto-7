package control

import view.ErrorMessage
import view.Input

class PurchaseAmountValidater {

    private var validatorTest = false
    private lateinit var amount: String

    fun validate(): MutableList<List<Int>> {
        while (!validatorTest) {
            amount = Input().purchaseAmountInput()
            purchaseAmountException()
        }
        return RandomLottoGenerator().purchase(amount.toInt())
    }

    private fun purchaseAmountException(): Any {
        try {
            checkBlank(amount)
            checkNumber(amount)
            checkBigNumber(amount)
            checkIntRange(amount)
            checkDivide(amount)
            validatorTest = true
            return true
        } catch (ex: Exception) {
            return println(ex.message)
        }
    }

    private fun checkBlank(amount: String) {
        require(amount.isNotBlank()) { ErrorMessage.BLANK }
    }

    private fun checkNumber(amount: String) {
        require(amount.contains(Regex("^[0-9]*$"))) { ErrorMessage.NOT_NUMBERS }
    }

    private fun checkBigNumber(amount: String) {
        require(amount.length < 11) { ErrorMessage.OUT_OF_INT_RANGE }
    }

    private fun checkIntRange(amount: String) {
        require(amount.toLong() < Int.MAX_VALUE) { ErrorMessage.OUT_OF_INT_RANGE }
    }

    private fun checkDivide(amount: String) {
        require(
            amount.toInt() % 1000 == 0 && amount.toInt() != 0
        ) { ErrorMessage.NOT_DIVIDE_THOUSAND }
    }
}