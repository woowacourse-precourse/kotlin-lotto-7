package lotto.util

object InputValidator {
    fun validateInputIsNumeric(input: String) {
        if (input.toIntOrNull() == null) throw IllegalArgumentException("[ERROR] 올바른 숫자가 아닙니다.")
    }
}
