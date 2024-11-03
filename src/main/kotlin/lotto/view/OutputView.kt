package lotto.view

import lotto.model.Rank
import lotto.model.lotto.LottoTicket
import lotto.model.message.OutputMessage

object OutputView {

    fun printLottoTickets(lottoTickets: List<LottoTicket>) {
        println(OutputMessage.LOTTO_TICKET_COUNT.message.format(lottoTickets.size))
        lottoTickets.forEach { println(it.getSortedNumbers()) }
    }

    fun printResults(ranks: List<Rank>) {
        println(OutputMessage.WINNING_STATISTICS_TITLE.message)
        val rankCounts = ranks.groupingBy { it }.eachCount()

        Rank.entries.filter { it != Rank.NONE }
            .forEach { rank -> printRankResult(rank, rankCounts) }
    }

    private fun printRankResult(rank: Rank, rankCounts: Map<Rank, Int>) {
        val count = rankCounts[rank] ?: 0
        val bonusText = getBonusText(rank)
        println(OutputMessage.RANK_RESULT.message.format(rank.matchCount, bonusText, rank.prize, count))
    }

    private fun getBonusText(rank: Rank): String {
        return if (rank.requiresBonus) OutputMessage.BONUS_TEXT.message else ""
    }
}