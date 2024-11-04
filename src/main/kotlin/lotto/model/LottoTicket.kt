package lotto.model

class LottoTicket {
    fun generateTickets(ticketCount: Int): List<Lotto> {
        return List(ticketCount) {Lotto.generate()}
    }

    fun calculateTickets(tickets: List<Lotto>, winningNumbers: Set<Int>, bonusNumber: Int): Map<LottoRank, Int> {
        return tickets.groupingBy { it.match(winningNumbers, bonusNumber) }.eachCount()
    }
}