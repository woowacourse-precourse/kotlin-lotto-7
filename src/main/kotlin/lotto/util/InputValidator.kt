package lotto.util

object InputValidator {
    const val EMPTY_INPUT_EXCEPTION_MESSAGE = "빈 문자열입니다."

    fun validateInputIsNotEmpty(input: String) =
        require(input.isNotBlank()) { EMPTY_INPUT_EXCEPTION_MESSAGE }
}