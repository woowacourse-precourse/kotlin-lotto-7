package lotto.domain

import lotto.resources.Messages.*

class InputValidator {
    fun commaStringValidate(input: String) {
        require(input.isNotBlank()) {
            ERROR_EMPTY_INPUT.errorMessage()
        }
        val elements = input.split(",")
        require(elements.size == elements.distinct().size) { ERROR_DUPLICATE_NAME.errorMessage() }
    }

    fun numberValidate(input: String) {
        require(input.isNotBlank()) { ERROR_EMPTY_INPUT.errorMessage() }
        require(input.length < 9) { ERROR_OVERSIZE_TRY_COUNT.errorMessage() }
        val number = runCatching { input.toInt() }
            .getOrElse { throw IllegalArgumentException(ERROR_NOT_POSITIVE.errorMessage()) }
        require(number > 0) { ERROR_NOT_POSITIVE.errorMessage() }
    }
}