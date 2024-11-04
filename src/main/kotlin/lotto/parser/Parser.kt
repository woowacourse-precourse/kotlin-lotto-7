package lotto.parser

class Parser {
    fun parsePurchaseAmount(input: String): Int {
        return input.toInt()
    }

    fun parseWinningNumbers(input: String): List<Int> {
        return input.split(",").map { it.trim().toInt() }
    }
}