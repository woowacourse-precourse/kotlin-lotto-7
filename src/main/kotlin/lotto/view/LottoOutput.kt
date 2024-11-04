package lotto.view

import lotto.model.Lotto
import lotto.model.Rank
import lotto.util.OutputMessages.BONUS_MATCH_MESSAGE
import lotto.util.OutputMessages.DIVIDER
import lotto.util.OutputMessages.FORMAT_MATCH_DESCRIPTION
import lotto.util.OutputMessages.FORMAT_RESULT
import lotto.util.OutputMessages.PROFIT_RATE_MESSAGE
import lotto.util.OutputMessages.RESULT_HEADER
import lotto.util.OutputMessages.TICKET_COUNT_MESSAGE

class LottoOutput {
    fun printTicketCount(ticketCount: Int) {
        println("\n$ticketCount$TICKET_COUNT_MESSAGE")
    }

    fun printLottoTickets(lottoTickets: List<Lotto>) {
        lottoTickets.forEach { println(it) }
    }

    fun printResult(results: Map<Rank, Int>) {
        printResultHeader()

        Rank.values()
            .filter { it != Rank.NONE }
            .forEach { rank ->
                val count = results[rank] ?: 0
                println(formatResult(rank, count))
            }
    }

    fun printProfitRate(profitRate: String) {
        println(String.format(PROFIT_RATE_MESSAGE, profitRate))    }

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
        if (rank.matchBonus) {
            return String.format(FORMAT_MATCH_DESCRIPTION, rank.matchCount, BONUS_MATCH_MESSAGE)
        }
        return String.format(FORMAT_MATCH_DESCRIPTION, rank.matchCount, "")
    }

    private fun formatPrize(prize: Int): String {
        return String.format("%,d", prize)
    }
}