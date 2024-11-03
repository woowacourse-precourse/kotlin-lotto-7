package lotto.domain.usecase

import lotto.domain.model.PurchaseInfo
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class QuickPickLottoTicketsTest {

    @Test
    fun `구매 정보에 따라 올바른 수의 로또 티켓이 생성되어야 한다`() {
        // given
        val purchaseInfo = PurchaseInfo(5000) // 5 tickets
        val quickPickLottoTickets = QuickPickLottoTickets(purchaseInfo)
        val tickets = quickPickLottoTickets.quickPickLottoTickets()

        assertEquals(5, tickets.size)
        tickets.forEach { ticket ->
            assertEquals(6, ticket.lottoNumbers.size) // 각 티켓은 6개의 번호를 가져야 함
            ticket.lottoNumbers.forEach { number ->
                assert(number in 1..45) // 각 번호는 1부터 45 사이여야 함
            }
        }
    }
}