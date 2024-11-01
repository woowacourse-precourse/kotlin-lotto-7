package lotto.view

import lotto.Lotto
import lotto.util.InfoMessages
import lotto.util.InputMessages

class OutputView {

    fun printPurchaseAmountPrompt() {
        println(InputMessages.PURCHASE_AMOUNT_PROMPT)
    }

    fun printNumberOfPurchase(numberOfPurchase: Int) {
        println()
        println("${numberOfPurchase}${InfoMessages.PURCHASE_AMOUNT_INFO}")
    }

    fun printUserLottoNumbers(lottoTickets: List<Lotto>) {
        for (lotto in lottoTickets) {
            println(lotto.getNumbers())
        }
    }

    fun printWinningNumbersPrompt() {
        println()
        println(InputMessages.WINNING_NUMBERS_PROMPT)
    }

    fun printBonusNumberPrompt() {
        println()
        println(InputMessages.BONUS_NUMBER_PROMPT)
    }

    fun printWinningStatistics(fifthCount: Int, fourthCount: Int, thirdCount: Int, secondCount: Int, firstCount: Int) {
        println()
        println(InfoMessages.WINNING_STATISTICS)
        println(String.format(InfoMessages.MATCH_COUNT_PRIZE_MESSAGE, 3, "5,000", fifthCount))
        println(String.format(InfoMessages.MATCH_COUNT_PRIZE_MESSAGE, 4, "50,000", fourthCount))
        println(String.format(InfoMessages.MATCH_COUNT_PRIZE_MESSAGE, 5, "1,500,000", thirdCount))
        println(String.format(InfoMessages.MATCH_COUNT_BONUS_PRIZE_MESSAGE, 5, "30,000,000", secondCount))
        println(String.format(InfoMessages.MATCH_COUNT_PRIZE_MESSAGE, 6, "2,000,000,000", firstCount))
    }

}