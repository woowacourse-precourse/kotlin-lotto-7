package lotto

class InputValidator {
    fun inputCheck(input: String) {
        try {
            isNull(input)
            isNumber(input)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    private fun isNumber(input:String) {
        try {
            input.toInt()
        } catch (e: IllegalArgumentException) {
            val errorMessage = ErrorMessage.INPUT_NOT_NUMBER
            throw IllegalArgumentException(errorMessage.getMessage())
        }
    }

    private fun isNull(input: String) {
        if (input.isBlank() || input.isEmpty()) {
            val errorMessage = ErrorMessage.INPUT_IS_NULL
            throw IllegalArgumentException(errorMessage.getMessage())
        }
    }
}