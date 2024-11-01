package lotto

import kotlin.properties.Delegates

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }

    // TODO: 추가 기능 구현
}

class LottoMachine() {
    var payment by Delegates.notNull<Int>()

    init {
        val input = IOHandler().inputToUser(paymentFirstInstruction)

        getDigitPayment(input)
        getUnderLimitPayment(payment)
        getUnit1000Payment(payment)
    }

    private fun getDigitPayment(input: String) {
        var tempInput = input

        if (!Validation().isDigit(tempInput)) {
            tempInput = IOHandler().inputToUser(paymentNotDigitInstruction)
            getDigitPayment(tempInput)
        }
        payment = tempInput.toInt()
    }

    private fun getUnderLimitPayment(tempPayment: Int) {
        if (!Validation().isPaymentUnder100000(tempPayment)) {
            val newInput = IOHandler().inputToUser(paymentOverLimitInstruction)

            getDigitPayment(newInput)
            getUnderLimitPayment(payment)
        }
    }

    private fun getUnit1000Payment(tempPayment: Int) {
        if (!Validation().isPaymentUnit1000(tempPayment)) {
            val newInput = IOHandler().inputToUser(paymentNot1000Instruction)

            getDigitPayment(newInput)
            getUnderLimitPayment(payment)
            getUnit1000Payment(payment)
        }
    }

    companion object {
        const val paymentFirstInstruction = "구입금액을 입력해 주세요."
        const val paymentNotDigitInstruction = "구입금액은 숫자로 입력해야 합니다. 구입금액을 다시 입력해주세요."
        const val paymentOverLimitInstruction = "구입 한도를 초과하였습니다. 10만원 이하의 금액을 입력해 주세요."
        const val paymentNot1000Instruction = "구입금액은 1000원 단위로 입력해야 합니다. 로또 1장의 가격은 1000원입니다. 구입금액을 다시 입력해 주세요."
    }
}