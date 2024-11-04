package lotto

import lotto.model.Lotto
import lotto.model.LottoRank
import lotto.model.LottoTicket
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoTicketTest {

    @Test
    fun `티켓을 지정된 개수만큼 생성한다`() {
        val lottoTicket = LottoTicket()
        val ticketCount = 5

        val generatedTickets = lottoTicket.generateTickets(ticketCount)

        assertEquals(ticketCount, generatedTickets.size)
    }
}