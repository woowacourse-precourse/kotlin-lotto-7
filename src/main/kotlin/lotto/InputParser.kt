package lotto

object InputParser {
    fun parsePaymentInput(input: String): Int {
        return input.toInt()
    }

    fun parseWinningNumbersInput(input: String): Iterable<Int> {
        return input.split(",").map { it -> it.toInt() }
    }

    fun parseBonusNumberInput(input: String): Int {
        return input.toInt()
    }

}