package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.domain.Money

const val MESSAGE_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."

fun getLottoPurchaseAmount(): Money {
    while (true) {
        try {
            println(MESSAGE_INPUT_PURCHASE_AMOUNT)
            val input = convertInt(readLineAndLineBreak())

            return Money(input)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            println()
        }
    }
}

private fun readLineAndLineBreak(): String {
    val input = Console.readLine()
    println()

    return input
}
