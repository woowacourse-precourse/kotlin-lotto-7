package lotto.ui

object OutputView {

    private const val OTHER_ERROR_MESSAGE = "다시 입력해주세요."

    fun printErrorCauseMessage(message: String) = println(message)

    fun printOtherErrorMessage() = println(OTHER_ERROR_MESSAGE)
}