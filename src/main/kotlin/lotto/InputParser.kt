package lotto

object InputParser {
    fun parsePaymentInput(input: String): Long {
        return input.toLong()
    }

    fun parseWinningNumbersInput(input: String): Iterable<Long> {
        return input.split(",").map { it -> it.toLong() }
    }

    fun parseBonusNumberInput(input: String): Long {
        return input.toLong()
    }

}