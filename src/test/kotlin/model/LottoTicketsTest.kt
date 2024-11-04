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
            val lottoTickets = LottoTickets(money).tickets

            // then
            assertThat(lottoTickets).isEqualTo(2)
        }
    }
}