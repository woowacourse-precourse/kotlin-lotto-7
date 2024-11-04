package lotto.model

class LottoTicket {

    private var lottoTickets: List<Lotto> = emptyList()

    fun generateTickets(ticketCount: Int): List<Lotto> {
        lottoTickets = List(ticketCount) { Lotto.generate() }
        return lottoTickets
    }

    fun calculateTickets(winningNumbers: List<Int>, bonusNumber: Int): Map<LottoRank, Int> {
        return lottoTickets.groupingBy { it.match(winningNumbers, bonusNumber) }.eachCount()
    }
}