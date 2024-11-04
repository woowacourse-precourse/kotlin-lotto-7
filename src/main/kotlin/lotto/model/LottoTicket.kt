package lotto.model

import lotto.util.ConstantsUtil.TICKET_PRICE

class LottoTicket {
    fun generateTickets(ticketsPrice: Int): List<Lotto> {
        val ticketCount = ticketsPrice / TICKET_PRICE
        return List(ticketCount) {Lotto.generate()}
    }

    fun calculateTickets(tickets: List<Lotto>, winningNumbers: Set<Int>, bonusNumber: Int): Map<LottoRank, Int> {
        return tickets.groupingBy { it.match(winningNumbers, bonusNumber) }.eachCount()
    }
}