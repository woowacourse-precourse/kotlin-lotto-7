package lotto.data

import lotto.constants.Error.ERROR_WINNING_NUMBER_COUNT
import lotto.constants.Error.ERROR_WINNING_NUMBER_DUPLICATE
import lotto.constants.Error.ERROR_WINNING_NUMBER_NOT_INTEGER
import lotto.constants.Error.ERROR_WINNING_NUMBER_OUT_OF_RANGE
import lotto.constants.Format.DELIMITER_COMMA
import java.lang.NumberFormatException

class Lotto(private val numbers: String) {
    init {
        numbers.split(DELIMITER_COMMA)
            .map { it.toIntOrNull() ?: throw NumberFormatException(ERROR_WINNING_NUMBER_NOT_INTEGER) }
        require(numbers.split(DELIMITER_COMMA).map { it.toInt() }.size == 6) { ERROR_WINNING_NUMBER_COUNT }
        require(numbers.split(DELIMITER_COMMA).all { it.toInt() in 1..45 }) { ERROR_WINNING_NUMBER_OUT_OF_RANGE }
        require(numbers.split(DELIMITER_COMMA).distinct().size == 6) { ERROR_WINNING_NUMBER_DUPLICATE }
    }

    constructor(numbers: List<Int>) : this(numbers.joinToString(DELIMITER_COMMA))   // 단위 테스트 시 인자가 `List<Int>`인 경우

    fun getWinningNumber(): List<Int> = numbers.split(DELIMITER_COMMA).map { it.toInt() }
}
