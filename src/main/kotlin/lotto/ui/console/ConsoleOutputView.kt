package lotto.ui.console

import lotto.domain.exception.ExceptionMessages
import lotto.domain.model.Lotto
import lotto.ui.OutputView

class ConsoleOutputView : OutputView {
    override fun displayExceptionMessage(exception: Throwable) {
        val message = exception.message ?: ExceptionMessages.DEFAULT_EXCEPTION_MESSAGE
        println("$EXCEPTION_MESSAGE_HEADER $message")
    }

    override fun displayAmount(amount: Int): Unit = println("$NEW_LINE_FEED${amount}$AMOUNT_MESSAGE")

    override fun displayLottoes(lottoes: List<Lotto>) {
        val stringBuilder = StringBuilder()

        for (lotto in lottoes) {
            stringBuilder.append(lotto.toString())
            stringBuilder.append(NEW_LINE_FEED)
        }

        println(stringBuilder.toString())
    }

    companion object {
        private const val EXCEPTION_MESSAGE_HEADER = "[ERROR]"
        private const val AMOUNT_MESSAGE = "개를 구매했습니다."
        private const val NEW_LINE_FEED = '\n'
    }
}
