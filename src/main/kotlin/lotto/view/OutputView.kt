package lotto.view

import lotto.constants.ErrorMessage
import lotto.constants.OutputMessage
import lotto.model.Lotto
import lotto.model.Rank
import lotto.model.Stat
import lotto.utils.Formatter

class OutputView {
    fun printLottoCount(lottoCount: Int) {
        println()
        println("$lottoCount" + OutputMessage.LOTTO_COUNT)
    }

    fun printLotto(lotto: List<Lotto>) {
        lotto.forEach {
            println(it.getNumbers())
        }
    }

    fun printStats(stats: List<Stat>) {
        println()
        println(OutputMessage.RESULT_TITLE)
        stats.forEach { stat ->
            val rank = stat.getRank()
            val count = stat.getCount()
            val bonusBallText = if (rank == Rank.SECOND) OutputMessage.MATCH_BONUS_NUMBER else ""
            val winningPrice = Formatter.addCommas(rank.winningPrice)
            println(
                "${rank.matchedNumber}" + OutputMessage.MATCH_COUNT + bonusBallText +
                        OutputMessage.PRICE_OPEN_BRACKET + winningPrice + OutputMessage.PRICE_CLOSE_BRACKET +
                        "$count" + OutputMessage.COUNT
            )
        }
    }

    fun printProfitRate(profitRate: String) {
        val formattedProfitRate = Formatter.addCommasToDecimal(profitRate.toDouble())
        print(OutputMessage.PROFIT_RATE_START)
        println(formattedProfitRate + OutputMessage.PROFIT_RATE_END)
    }

    fun printErrorMessage(errorMessage: String?) {
        println(errorMessage ?: ErrorMessage.DEFAULT_ERROR)
    }
}