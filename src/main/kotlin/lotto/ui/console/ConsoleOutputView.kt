package lotto.ui.console

import lotto.domain.exception.ExceptionMessages
import lotto.domain.model.Lotto
import lotto.domain.model.LottoWinPlace
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

    override fun displayLottoResults(lottoWinPlaces: Map<LottoWinPlace, Int>) {
        val stringBuilder = StringBuilder()
        val availableWinPlaces = LottoWinPlace.entries.reversed()

        stringBuilder.appendLine()
        stringBuilder.appendLine(RESULT_HEADER)
        stringBuilder.appendLine(SECTION_SEPARATOR)

        for (availableWinPlace in availableWinPlaces) {
            val winPlaceCount = lottoWinPlaces[availableWinPlace] ?: 0
            stringBuilder.appendLine(availableWinPlace.convertToString(winPlaceCount))
        }

        println(stringBuilder.toString())
    }

    private fun LottoWinPlace.convertToString(count: Int): String =
        "${requiredMatchedNumberLength}개 일치${bonusWinningNumberMatched()} (${PRIZE_FORMAT.format(prize)}$KRW) - ${count}개"

    private fun LottoWinPlace.bonusWinningNumberMatched(): String {
        if (shouldBonusWinningBeNumberMatched) return BONUS_WINNING_NUMBER_MATCH
        return EMPTY_STRING
    }

    companion object {
        private const val EXCEPTION_MESSAGE_HEADER = "[ERROR]"
        private const val AMOUNT_MESSAGE = "개를 구매했습니다."
        private const val NEW_LINE_FEED = '\n'
        private const val PRIZE_FORMAT = "%,d"
        private const val KRW = "원"
        private const val RESULT_HEADER = "당첨 통계"
        private const val SECTION_SEPARATOR = "---"
        private const val BONUS_WINNING_NUMBER_MATCH = ", 보너스 볼 일치"
        private const val EMPTY_STRING = ""
    }
}
