package lotto.view

import lotto.model.LottoRank
import lotto.model.LottoTicket
import lotto.utils.OutputConstants.WINNING_STATISTICS

class OutputView {

    fun showPurchaseLottoDetails(count: Int, tikets: List<LottoTicket>) {
        println("\n${count}개를 구매했습니다.")
        tikets.forEach { println(it.numbers) }
    }

    fun showLottoResult(rankCounts: Map<LottoRank, Int>) {
        println(WINNING_STATISTICS)
        rankCounts.forEach { (rank, count) ->
            when {
                rank == LottoRank.NONE -> return
                rank != LottoRank.SECOND -> println("${rank.matchCount}개 일치 (${String.format("%,d", rank.reward)}원) - ${count}개")
                rank == LottoRank.SECOND -> println("${rank.matchCount}개 일치, 보너스 볼 일치 (${String.format("%,d", rank.reward)}원) - ${count}개")
            }
        }
    }

    fun showTotalReturnRate(totalReturnRate: Double) = println("\n총 수익률은 $totalReturnRate%입니다.")
}