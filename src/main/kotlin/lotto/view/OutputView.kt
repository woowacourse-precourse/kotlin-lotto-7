package lotto.view

import lotto.model.Rank
import lotto.model.lotto.LottoTicket

object OutputView {

    fun printLottoTickets(lottoTickets: List<LottoTicket>) {
        println("\n${lottoTickets.size}개를 구매했습니다.")
        lottoTickets.forEach { println(it.getSortedNumbers()) }
    }

    fun printResults(ranks: List<Rank>) {
        println("\n당첨 통계\n---")
        val rankCounts = ranks.groupingBy { it }.eachCount()

        Rank.entries.filter { it != Rank.NONE }
            .forEach { rank -> printRankResult(rank, rankCounts) }
    }

    private fun printRankResult(rank: Rank, rankCounts: Map<Rank, Int>) {
        val count = rankCounts[rank] ?: 0
        val bonusText = getBonusText(rank)
        println("${rank.matchCount}개 일치$bonusText (${rank.prize}원) - $count 개")
    }

    private fun getBonusText(rank: Rank): String {
        return if (rank.requiresBonus) "+ 보너스" else ""
    }
}