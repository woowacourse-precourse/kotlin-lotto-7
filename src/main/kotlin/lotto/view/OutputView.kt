package lotto.view

import lotto.Constants.OUTPUT_LOTTO_TICKET_COUNT_MESSAGE
import lotto.Constants.OUTPUT_LOTTO_WINNING_MESSAGE
import lotto.model.LottoGenerator
import lotto.model.LottoRank

class OutputView {
    fun countTicketsMessage(ticket: Int) {
        print("\n" + String.format(OUTPUT_LOTTO_TICKET_COUNT_MESSAGE, ticket))
    }

    fun generateTicketsMessage(ticketCount: Int) {
        val lottoGenerator = LottoGenerator()
        val tickets = lottoGenerator.generateLottoTickets(ticketCount)

        tickets.forEach { ticket -> print(ticket.sorted()) }
    }

    fun displayWinningMessage() {
        println("\n$OUTPUT_LOTTO_WINNING_MESSAGE")
        println("---")
        LottoRank.values().forEach { rank ->
            println("${rank.matchCount}개 일치 (${rank.prize}원) - ${rank.count}개")
        }
    }
}