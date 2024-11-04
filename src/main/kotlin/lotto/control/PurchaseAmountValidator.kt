package lotto.control

import lotto.util.ErrorMessage
import lotto.util.SettingValue
import lotto.view.Input

class PurchaseAmountValidator {
    private var validatorTest = false
    private lateinit var amount: String

    // Stack Overflow 방지 위해 while 구현
    fun validate(): MutableList<List<Int>> {
        while (!validatorTest) {
            amount = Input().purchaseAmountInput()
            checkException()
        }
        return RandomLottoGenerator().generate(amount.toInt())
    }

    private fun checkException() {
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
        if (amount.isBlank()) {
            throw IllegalArgumentException(ErrorMessage.EMPTY_PURCHASED_NUMBER)
        }
    }

    private fun checkNumber(amount: String) {
        if (!amount.contains(Regex("^[0-9]*$"))) {
            throw NumberFormatException(ErrorMessage.NOT_NUMBERS)
        }
    }

    private fun checkBigNumber(amount: String) {
        if (amount.length > SettingValue.OUT_OF_INT_LENGTH) {
            throw IllegalArgumentException(ErrorMessage.OUT_OF_INT_RANGE)
        }
    }

    private fun checkIntRange(amount: String) {
        if (amount.toLong() > Int.MAX_VALUE) {
            throw ArithmeticException(ErrorMessage.OUT_OF_INT_RANGE)
        }
    }

    private fun checkDivide(amount: String) {
        if (amount.toInt() % SettingValue.LOTTO_PRICE != 0 ||
            amount.toInt() == 0
        ) {
            throw IllegalArgumentException(ErrorMessage.NOT_DIVIDE_THOUSAND)
        }
    }

    internal fun checkDivideTest(amount: String) {
        return checkDivide(amount)
    }

    internal fun checkIntRangeTest(amount: String) {
        return checkIntRange(amount)
    }
}