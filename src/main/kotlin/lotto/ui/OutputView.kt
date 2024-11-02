package lotto.ui

object OutputView {

    private const val OTHER_ERROR_MESSAGE = "[ERROR] 다시 입력해주세요."
    private const val LOTTO_QUANTITY_MESSAGE = "%d개를 구매했습니다."

    fun printErrorCauseMessage(message: String) = println(message)

    fun printOtherErrorMessage() = println(OTHER_ERROR_MESSAGE)

    fun printNewLine() = println()

    fun printLottoQuantity(quantity: Int) = println(LOTTO_QUANTITY_MESSAGE.format(quantity))

    fun printLottoNumber(number: List<Int>) = println(number)
}