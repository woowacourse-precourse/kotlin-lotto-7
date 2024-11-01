package lotto.view

import lotto.util.Constants.LOTTO_RANK_FIFTH_WINNING_AMOUNT
import lotto.util.Constants.LOTTO_RANK_FIRST_WINNING_AMOUNT
import lotto.util.Constants.LOTTO_RANK_FOURTH_WINNING_AMOUNT
import lotto.util.Constants.LOTTO_RANK_SECOND_WINNING_AMOUNT
import lotto.util.Constants.LOTTO_RANK_THIRD_WINNING_AMOUNT
import java.text.DecimalFormat

class OutputView {

    private val integerCommaFormat = DecimalFormat("#,###")
    private val decimalCommaFormat = DecimalFormat("#,##0.0")

    fun printPurchasedLottoCount(count: Int) {
        println("\n${PURCHASE_NUMBER_PROMPT.format(count)}")
    }

    fun printPurchasedLottoNumbers(lottoNumbers: List<List<Int>>) {
        lottoNumbers.forEach { println(it) }
    }

    fun printLottoResult(ranks: List<Int>) {
        println(LOTTO_RESULT_HEADER)

        printRankResult(3, LOTTO_RANK_FIFTH_WINNING_AMOUNT, ranks[4])
        printRankResult(4, LOTTO_RANK_FOURTH_WINNING_AMOUNT, ranks[3])
        printRankResult(5, LOTTO_RANK_THIRD_WINNING_AMOUNT, ranks[2])
        printRankResult(5, LOTTO_RANK_SECOND_WINNING_AMOUNT, ranks[1], includeBonus = true)
        printRankResult(3, LOTTO_RANK_FIRST_WINNING_AMOUNT, ranks[0])
    }

    fun printProfitRate(profitRate: Double) {
        println(LOTTO_PROFIT_RATE_PROMPT.format(profitRate.toDecimalCommaFormat()))
    }

    private fun printRankResult(matches: Int, winningAmount: Int, count: Int, includeBonus: Boolean = false) {
        val bonusText = if (includeBonus) BONUS_TEXT else ""
        println(RESULT_PROMPT.format(matches, bonusText, winningAmount.toIntegerCommaFormat(), count))
    }

    private fun Int.toIntegerCommaFormat(): String = integerCommaFormat.format(this)
    private fun Double.toDecimalCommaFormat(): String = decimalCommaFormat.format(this)

    companion object {
        private const val PURCHASE_NUMBER_PROMPT = "%s개를 구매했습니다."
        private const val LOTTO_RESULT_HEADER = "\n구매 통계\n---"
        private const val RESULT_PROMPT = "%s개 일치%s (%s원) - %s개"
        private const val BONUS_TEXT = ", 보너스 볼 일치"
        private const val LOTTO_PROFIT_RATE_PROMPT = "총 수익률은 %s%%입니다."
    }
}
