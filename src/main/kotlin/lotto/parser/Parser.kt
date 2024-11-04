package lotto.parser

import lotto.util.ExceptionConstants

class Parser {
    fun parsePurchaseAmount(input: String): Int {
        return input.toInt()
    }

    fun parseWinningNumbers(input: String): List<Int> {
        val delimiter = ","
        require(input.contains(delimiter)) { ExceptionConstants.ERROR_INVALID_DELIMITER }

        return input.split(delimiter).map { it.trim().toInt() }
    }

    fun parseBonusNumber(input: String): Int {
        return input.toInt()
    }
}