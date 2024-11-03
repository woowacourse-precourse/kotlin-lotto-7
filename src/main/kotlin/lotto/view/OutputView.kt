package lotto.view

import lotto.model.Lotto
import lotto.model.LottoRank

class OutputView {
    fun printLottoCount(count: Int) {
        println("$count$MESSAGE_LOTTO_COUNT")
    }

    fun printLottos(lottos: Set<Lotto>) {
        lottos.forEach { println(it.toString()) }
    }

    private fun formatWinCountsMessage(winCounts: Map<LottoRank, Int>, rank: LottoRank): String {
        val message = MESSAGE_WIN_COUNTS.format(
            rank.matchCount,
            "%,d".format(rank.prize),
            if (rank.hasBonus) MESSAGE_HAS_BONUS else "",
            winCounts.getOrDefault(rank, 0))
        return message
    }

    fun printWinCounts(winCounts: Map<LottoRank, Int>) {
        println(MESSAGE_RESULT_HEADER)
        LottoRank.entries.dropLast(1).reversed().forEach {
            println(formatWinCountsMessage(winCounts, it))
        }
    }

    companion object {
        const val MESSAGE_LOTTO_COUNT = "개를 구매했습니다."
        const val MESSAGE_RESULT_HEADER = "당첨 통계\n---"
        const val MESSAGE_WIN_COUNTS = "%d개 일치 (%s원)%s - %d개"
        const val MESSAGE_HAS_BONUS = ", 보너스 볼 일치"
    }
}
