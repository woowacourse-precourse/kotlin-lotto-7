package lotto.converter

import lotto.exception.ExceptionCode
import lotto.exception.LottoException

object LottoArgumentConverter {
    private const val LOTTO_DELIMITER = ","

    fun toLottoArgument(input: String): List<Int> {
        val candidate = input.split(LOTTO_DELIMITER)
        validateNumeric(candidate)
        return candidate.map { it.toInt() }.toList()
    }

    private fun validateNumeric(input: List<String>) {
        input.forEach {
            it.toIntOrNull() ?: throw LottoException(ExceptionCode.INVALID_NUMERIC)
        }
    }
}