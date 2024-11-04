package model

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketsTest {
    @Test
    fun `로또 구매 갯수를 가진다`() {
        assertSimpleTest {
            // given
            val money = 2_000

            // when
            val lottoTicketCounts = LottoTickets(money).ticketCounts

            // then
            assertThat(lottoTicketCounts).isEqualTo(2)
        }
    }

    @Test
    fun `구매 갯수만큼의 로또 티켓들을 가진다`() {
        assertSimpleTest {
            // given
            val money = 2_000

            // when
            val lottoTickets = LottoTickets(money).lottoTickets

            // then
            assertThat(lottoTickets.size).isEqualTo(2)
        }
    }
}