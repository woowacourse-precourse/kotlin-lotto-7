package lotto

import kotlin.properties.Delegates

class LottoMachine {
    var payment by Delegates.notNull<Int>()

    init {
        val input = IOHandler().inputToUser(PAYMENRFIRSTINSTRUCTION)

        payment = getCorrectPayment(input)
    }

    fun calculateAmountOfLotto(): Int {
        return payment % 1000
    }

    private fun getCorrectPayment(input: String): Int {
        var tempInput = input

        return try {
            Validation().checkPayment(tempInput)
        } catch (e: IllegalArgumentException) {
            tempInput = IOHandler().inputToUser("${e.message} $PAYMENTRETRYINSTRUCTION")
            getCorrectPayment(tempInput)
        }
    }

    companion object {
        const val PAYMENRFIRSTINSTRUCTION = "구입금액을 입력해 주세요."
        const val PAYMENTRETRYINSTRUCTION = "구입금액을 다시 입력해주세요."
    }
}