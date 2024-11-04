package lotto.util

object InputValidator {
    fun validateInput(input: String) {
        validateNull(input)
        validateDigit(input)
        validateNatural(input)
    }

    private fun validateNull(input: String) {
        require(input.trim().isNotEmpty()) {
            ErrorMessage.INPUT_NULL.getMessage()
        }
    }

    private fun validateDigit(input: String) {
        require(input.toIntOrNull() != null) {
            ErrorMessage.INPUT_DIGIT.getMessage()
        }
    }

    private fun validateNatural(input: String) {
        require(input.trim().toInt() > 0) {
            ErrorMessage.INPUT_NATURAL.getMessage()
        }
    }
}
