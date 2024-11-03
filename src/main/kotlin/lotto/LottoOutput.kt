package lotto

class LottoOutput {
    fun printTicketCount(ticketCount: Int) {
        println()
        println("$ticketCount $TICKET_COUNT_MESSAGE" )
    }

    fun printLottoTickets(lottoTickets: List<Lotto>) {
        lottoTickets.forEach { println(it) }
    }

    companion object{
        private const val TICKET_COUNT_MESSAGE = "개를 구매했습니다."
    }
}