package lotto.util

import lotto.util.ExceptionConstants.ERROR_MESSAGE_INPUT_EMPTY

object InputValidator {

    fun validateInputIsNotEmpty(input: String) =
        require(input.isNotBlank()) { ERROR_MESSAGE_INPUT_EMPTY }
}