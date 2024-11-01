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

    fun printWinStatistics(lottoMatch: Map<MatchingLottoCount, Int>) {
        val matchCount = mutableListOf<Int>()
        for (i in MatchingLottoCount.entries) {
            matchCount.add(lottoMatch[i] ?: 0)
        }

        val winningMsg = listOf(
            PRINT_MATCH_THREE_LOTTO_NUMBER_MESSAGE,
            PRINT_MATCH_FOUR_LOTTO_NUMBER_MESSAGE,
            PRINT_MATCH_FIVE_LOTTO_NUMBER_MESSAGE,
            PRINT_MATCH_FIVE_LOTTO_NUMBER_AND_BONUS_MESSAGE,
            PRINT_MATCH_SIX_LOTTO_NUMBER_MESSAGE
        )

        val msg = winningMsg.zip(matchCount) { msg, count ->
            "${msg}${count}$PRINT_COUNT_UNIT_MESSAGE"
        }

        println(PRINT_WINNING_STATISTICS_MESSAGE)
        println("---")
        repeat(msg.size) {
            println(msg[it])
        }

    }

    companion object {
        const val PRINT_PURCHASE_LOTTO_COUNT_MESSAGE = "개를 구매했습니다."
        const val PRINT_WINNING_STATISTICS_MESSAGE = "당첨 통계"
        const val PRINT_MATCH_THREE_LOTTO_NUMBER_MESSAGE = "3개 일치 (5,000원) - "
        const val PRINT_MATCH_FOUR_LOTTO_NUMBER_MESSAGE = "4개 일치 (50,000원) - "
        const val PRINT_MATCH_FIVE_LOTTO_NUMBER_MESSAGE = "5개 일치 (1,500,000원) - "
        const val PRINT_MATCH_FIVE_LOTTO_NUMBER_AND_BONUS_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - "
        const val PRINT_MATCH_SIX_LOTTO_NUMBER_MESSAGE = "6개 일치 (2,000,000,000원) - "
        const val PRINT_COUNT_UNIT_MESSAGE = "개"

    }


}