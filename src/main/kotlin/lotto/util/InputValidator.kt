package lotto.util

object InputValidator {
    fun validateInputIsNumeric(input: String) {
        if (input.toIntOrNull() == null) throw IllegalArgumentException(ErrorMessage.ERROR_INPUT_NOT_NUMERIC)
    }
}
