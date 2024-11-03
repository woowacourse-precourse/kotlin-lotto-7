package lotto.view

import lotto.Lotto
import lotto.Rank

class LottoOutput {
    fun printTicketCount(ticketCount: Int) {
        println("\n$ticketCount $TICKET_COUNT_MESSAGE")
    }

    fun printLottoTickets(lottoTickets: List<Lotto>) {
        lottoTickets.forEach { println(it) }
    }

    fun printResult(results: Map<Rank, Int>) {
        printResultHeader()

        val ranks = listOf(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST)
        ranks.forEach { rank ->
            val count = results[rank] ?: 0
            println(formatResult(rank, count))
        }
    }

    private fun printResultHeader() {
        println(RESULT_HEADER)
        println(DIVIDER)
    }

    private fun formatResult(rank: Rank, count: Int): String {
        val matchDescription = getMatchDescription(rank)
        val formattedPrize = formatPrize(rank.prize)
        return String.format(FORMAT_RESULT, matchDescription, formattedPrize, count)
    }

    private fun getMatchDescription(rank: Rank): String {
        return if (rank.matchBonus) {
            String.format(FORMAT_MATCH_DESCRIPTION, rank.matchCount, BONUS_MATCH_MESSAGE)
        } else {
            String.format(FORMAT_MATCH_DESCRIPTION, rank.matchCount, "")
        }
    }

    private fun formatPrize(prize: Int): String {
        return String.format("%,d", prize)
    }

    companion object {
        private const val TICKET_COUNT_MESSAGE = "개의 로또를 구매했습니다."
        private const val RESULT_HEADER = "\n당첨 통계"
        private const val DIVIDER = "---"
        private const val FORMAT_RESULT = "%s (%s원) - %d개"
        private const val FORMAT_MATCH_DESCRIPTION = "%d개 일치%s"
        private const val BONUS_MATCH_MESSAGE = ", 보너스 볼 일치"
    }
}