package lotto.domain

import lotto.model.Lotto
import lotto.resources.Messages.*

class InputValidator {
    fun validateMoney(input: String): Long {
        require(input.isNotBlank() && input.isNotEmpty()) { EMPTY_INPUT.errorMessage() }
        val money = input.toLongOrNull()
            ?: throw IllegalArgumentException(NOT_NUMBER.errorMessage())
        require(money > 0L && money % MONEY_UNIT == 0L) { NOT_DIVIDED_BY_UNIT.errorMessage() }
        return money
    }

    fun validateWinNumbers(input: String): Lotto {
        require(input.isNotBlank() && input.isNotEmpty()) { EMPTY_INPUT.errorMessage() }
        val winningNumbersText = input.split(",")
        require(winningNumbersText.size == LOTTO_LENGTH) { NOT_SIX_NUMBER.errorMessage() }
        require(winningNumbersText.distinct().size == LOTTO_LENGTH) { DUPLICATE_LOTTO_NUMBER.errorMessage() }
        val winningNumbers = winningNumbersText.map {
            it.toIntOrNull() ?: throw IllegalArgumentException(NOT_NUMBER.errorMessage())
        }.sorted()
        require(winningNumbers.all { it in LOTTO_RANGE }) { INVALID_LOTTO_RANGE.errorMessage() }
        return Lotto(winningNumbers)
    }

    companion object {
        const val MONEY_UNIT = 1000
        const val LOTTO_LENGTH = 6
        const val LOTTO_START_VALUE = 1
        const val LOTTO_END_VALUE = 45
        val LOTTO_RANGE = LOTTO_START_VALUE..LOTTO_END_VALUE
    }
}