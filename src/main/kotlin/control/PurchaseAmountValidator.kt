import control.RandomLottoGenerator
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

    private fun purchaseAmountException() {
        try {
            checkBlank(amount)
            checkNumber(amount)
            checkBigNumber(amount)
            checkIntRange(amount)
            checkDivide(amount)
            validatorTest = true
        } catch (ex: Exception) {
            println(ex.message)
        }
    }

    private fun checkBlank(amount: String) {
        if (amount.isBlank()) throw IllegalArgumentException(ErrorMessage.EMPTY_PURCHASED_NUMBER)
    }

    private fun checkNumber(amount: String) {
        if (!amount.contains(Regex("^[0-9]*$"))) throw NumberFormatException(ErrorMessage.NOT_NUMBERS)
    }

    private fun checkBigNumber(amount: String) {
        if (amount.length > 11) throw IllegalArgumentException(ErrorMessage.OUT_OF_INT_RANGE)
    }

    private fun checkIntRange(amount: String) {
        if (amount.toLong() > Int.MAX_VALUE) throw ArithmeticException(ErrorMessage.OUT_OF_INT_RANGE)
    }

    private fun checkDivide(amount: String) {
        if (
            amount.toInt() % 1000 != 0 || amount.toInt() == 0
        ) throw IllegalArgumentException(ErrorMessage.NOT_DIVIDE_THOUSAND)
    }
}