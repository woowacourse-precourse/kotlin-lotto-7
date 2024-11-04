package lotto.view

import lotto.controller.MatchingLottoCount
import lotto.model.Lotto
import lotto.model.Random

class OutputView {

    fun printPurchaseLottoCount(count: Int) {
        println("${count}$PRINT_PURCHASE_LOTTO_COUNT_MESSAGE")
    }

    fun printPurchaseLotto(lottos: List<Lotto>) {
        for (lotto in lottos) {
            println(lotto)
        }
        println()
    }

    fun printWinStatistics(lottoMatch: Map<MatchingLottoCount, Int>, amountOfProfit: Float) {
        println(PRINT_WINNING_STATISTICS_MESSAGE)
        println("---")
        MatchingLottoCount.entries.forEach {
            println("${it.prefix} ${lottoMatch[it] ?: 0}$PRINT_COUNT_UNIT_MESSAGE")
        }
        println("$PRINT_TOTAL_AMOUNT_OF_PROFIT_PREFIX_MESSAGE $amountOfProfit$PRINT_TOTAL_AMOUNT_OF_PROFIT_SUFFIX_MESSAGE")
    }

    companion object {
        const val PRINT_PURCHASE_LOTTO_COUNT_MESSAGE = "개를 구매했습니다."
        const val PRINT_WINNING_STATISTICS_MESSAGE = "당첨 통계"
        const val PRINT_COUNT_UNIT_MESSAGE = "개"
        const val PRINT_TOTAL_AMOUNT_OF_PROFIT_PREFIX_MESSAGE = "총 수익률은"
        const val PRINT_TOTAL_AMOUNT_OF_PROFIT_SUFFIX_MESSAGE = "%입니다."
    }


}