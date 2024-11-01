package lotto.util

import lotto.util.Constants.EXCEPTION_PREFIX

object InputValidator {
    const val EMPTY_INPUT_EXCEPTION_MESSAGE = "빈 문자열입니다."

    fun validateInputIsNotEmpty(input: String) =
        require(input.isNotBlank()) { EXCEPTION_PREFIX + EMPTY_INPUT_EXCEPTION_MESSAGE }
}