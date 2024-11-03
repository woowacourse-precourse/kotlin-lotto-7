package lotto.view

import lotto.Constants.OUTPUT_LOTTO_TICKET_COUNT_MESSAGE
import lotto.model.LottoGenerator

class OutputView {
    fun countTicketsMessage(ticket: Int) {
        print("\n" + String.format(OUTPUT_LOTTO_TICKET_COUNT_MESSAGE, ticket))
    }

    fun generateTicketsMessage(ticketCount: Int) {
        val lottoGenerator = LottoGenerator()
        val tickets = lottoGenerator.generateLottoTickets(ticketCount)

        tickets.forEach { ticket -> print(ticket.sorted()) }
    }
}