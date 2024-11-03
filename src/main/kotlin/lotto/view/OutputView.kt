package lotto.view

import lotto.model.LottoRank
import lotto.model.LottoTicket
import lotto.utils.OutputConstants.WINNING_STATISTICS

class OutputView {

    fun showPurchasedLottoCount(count: Int, tikets: List<LottoTicket>) {
        println("\n${count}개를 구매했습니다.")
        tikets.forEach { println(it.numbers) }
    }

    fun showLottoResult(rankCounts: Map<LottoRank, Int>) {
        println(WINNING_STATISTICS)
        rankCounts.forEach { (rank, count) ->
            if (rank != LottoRank.NONE) {
                println("${rank.matchCount}개 일치 (${rank.reward}원) - ${count}개")
            }
        }
    }

    fun showTotalReturnRate(totalReturnRate: Float) = println("총 수익률은 $totalReturnRate%입니다.")
}