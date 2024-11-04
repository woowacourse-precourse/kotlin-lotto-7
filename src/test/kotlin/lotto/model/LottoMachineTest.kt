package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoMachineTest {
    @Test
    @DisplayName("생성되는 로또의 개수는 금액을 로또 가격으로 나눈 것과 일치한다.")
    fun lottoTickets_amount_test() {
        val money = Money(5000)
        val lottoMachine = LottoMachine(money)

        assertEquals(money.getLottoCount(), lottoMachine.lottoTickets.size)
    }

    @Test
    @DisplayName("로또 티켓 DTO 리스트의 크기는 생성되는 로또의 개수와 일치한다.")
    fun lottoTickets_DTO_test() {
        val money = Money(5000)
        val lottoMachine = LottoMachine(money)

        val dtoList = lottoMachine.generateLottoTicketDTOList()
        assertEquals(lottoMachine.lottoTickets.size, dtoList.size)
    }
}
