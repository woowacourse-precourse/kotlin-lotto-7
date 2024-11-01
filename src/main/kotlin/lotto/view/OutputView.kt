package lotto.view

import lotto.constants.OutputMessage
import lotto.model.Lotto
import lotto.model.Rank
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

    fun printWinningStats(rankCount: Map<Rank, Int>) {
        println()
        println(OutputMessage.RESULT_TITLE)
        rankCount.entries.forEach { (rank, count) ->
            print("${rank.matchedNumber}" + OutputMessage.MATCH_COUNT)
            if (rank == Rank.SECOND) print(OutputMessage.MATCH_BONUS_NUMBER)
            print(OutputMessage.PRICE_OPEN_BRACKET + Formatter.decimalFormatter(rank.winningPrice) + OutputMessage.PRICE_CLOSE_BRACKET)
            println("$count" + OutputMessage.COUNT)
        }
    }

    fun printProfitRate(profitRate: String) {
        print(OutputMessage.PROFIT_RATE_START)
        println(profitRate + OutputMessage.PROFIT_RATE_END)
    }
}