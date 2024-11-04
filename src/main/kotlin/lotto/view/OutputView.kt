package lotto.view

import lotto.model.Lotto
import lotto.model.LottoRank

class OutputView {
    fun printLottoCount(count: Int) {
        println("$count$MESSAGE_LOTTO_COUNT")
    }

    fun printLottos(lottos: Set<Lotto>) {
        lottos.forEach { println(it.toString()) }
        println()
    }

    private fun formatWinCountsMessage(winCounts: Map<LottoRank, Int>, rank: LottoRank): String {
        val message = MESSAGE_WIN_COUNTS.format(
            rank.matchCount,
            if (rank.hasBonus) MESSAGE_HAS_BONUS else "",
            "%,d".format(rank.prize),
            winCounts.getOrDefault(rank, 0))
        return message
    }

    fun printWinCounts(winCounts: Map<LottoRank, Int>) {
        println(MESSAGE_RESULT_HEADER)
        LottoRank.entries.dropLast(1).reversed().forEach {
            println(formatWinCountsMessage(winCounts, it))
        }
    }

    fun printRevenueToCostRatio(revenue: Int, cost: Int) {
        println(MESSAGE_PROFIT_TO_COST_RATIO.format(revenue.toFloat() / cost * 100))
    }

    companion object {
        const val MESSAGE_LOTTO_COUNT = "개를 구매했습니다."
        const val MESSAGE_RESULT_HEADER = "당첨 통계\n---"
        const val MESSAGE_WIN_COUNTS = "%d개 일치%s (%s원) - %d개"
        const val MESSAGE_HAS_BONUS = ", 보너스 볼 일치"
        const val MESSAGE_PROFIT_TO_COST_RATIO = "총 수익률은 %.1f%%입니다."
    }
}
