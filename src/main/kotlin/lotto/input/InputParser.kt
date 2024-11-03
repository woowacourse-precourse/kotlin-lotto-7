package lotto.input

object InputParser {
    fun parsePaymentInput(input: String): Int {
        return input.toInt()
    }

    fun parseWinningNumbersInput(input: String): List<Int> {
        return input.split(",").map { it -> it.toInt() }
    }

    fun parseBonusNumberInput(input: String): Int {
        return input.toInt()
    }
}