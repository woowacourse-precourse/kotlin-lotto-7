package View

import Utils.PrintUtils

object OutputView {
    fun printMoneyMessage() {
        println(PrintUtils.ENTER_MONEY)
    }

    fun printExceptionMessage(message: String) {
        println(message)
    }
}