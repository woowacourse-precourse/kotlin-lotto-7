package lotto.domain

import lotto.resources.Messages.*

class InputValidator {
    fun validateMoney(input: String): Long {
        require(input.isNotBlank() && input.isNotEmpty()) { EMPTY_INPUT.errorMessage() }
        val money = input.toLongOrNull()
            ?: throw IllegalArgumentException(NOT_NUMBER.errorMessage())
        require(money > 0L && money % MONEY_UNIT == 0L) { NOT_DIVIDED_BY_UNIT.errorMessage() }
        return money
    }

    companion object {
        const val MONEY_UNIT = 1000
    }
}