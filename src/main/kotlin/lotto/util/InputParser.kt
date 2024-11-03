package lotto.util

object InputParser {
    fun parseNumericInput(input: String): Int {
        if (input.toIntOrNull() == null) throw IllegalArgumentException(ErrorMessage.INPUT_NOT_NUMERIC)
        return input.toInt()
    }

    fun parseWinningNumbers(input: String): List<Int> {
        val numbers = mutableListOf<Int>()
        input.split(Constant.INPUT_DELIMITER).forEach { numbers.add(parseNumericInput(it)) }
        return numbers.sorted()
    }
}
