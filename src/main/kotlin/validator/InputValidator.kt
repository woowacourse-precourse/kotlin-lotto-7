package validator

class InputValidator {
    fun inputCheck(input: String): Boolean {
        var error = false
        try {
            isNull(input)
            isNumber(input)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            error = true
        }
        return error
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