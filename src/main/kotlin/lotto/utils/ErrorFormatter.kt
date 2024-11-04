package lotto.utils

object ErrorFormatter {
    private const val ERROR_LABLE = "[ERROR]"

    fun getErrorMessage(message : String) : String {
        return "$ERROR_LABLE $message"
    }
}