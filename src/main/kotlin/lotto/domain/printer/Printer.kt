package lotto.domain.printer

import lotto.domain.enums.Output

class Printer {
    fun printMessage(message: String) {
        println(message)
    }

    fun printWithLineBreak(msg: String) {
        lineBreak()
        println(msg)
    }

    fun printWinningMessage() {
        lineBreak()
        println(Output.WINNING_STATISTICS)
        println(Output.THREE_HYPHEN)
    }

    fun lineBreak() = println()
}