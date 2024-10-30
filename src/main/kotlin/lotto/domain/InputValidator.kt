package lotto.domain

import lotto.resources.Messages.*

class InputValidator {
    fun commaStringValidate(input: String) {
        require(input.isNotBlank()) {
            EMPTY_INPUT.errorMessage()
        }
        val elements = input.split(",")
        require(elements.size == elements.distinct().size) { DUPLICATE_NAME.errorMessage() }
    }

    fun numberValidate(input: String) {
        require(input.isNotBlank()) { EMPTY_INPUT.errorMessage() }
        require(input.length < 9) { OVERSIZE_TRY_COUNT.errorMessage() }
        val number = runCatching { input.toInt() }
            .getOrElse { throw IllegalArgumentException(NOT_POSITIVE.errorMessage()) }
        require(number > 0) { NOT_POSITIVE.errorMessage() }
    }
}