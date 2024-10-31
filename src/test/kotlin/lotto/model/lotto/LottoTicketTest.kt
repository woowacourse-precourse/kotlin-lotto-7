package lotto.model.lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTicketTest {

    @Test
    fun `LottoTicket이 오름차순으로 출력`() {
        //given
        val validNumbers = listOf(12, 3, 5, 19, 24, 45)
        //when
        val lottoTicket = LottoTicket(validNumbers)
        //then
        val sortedNumbers = lottoTicket.getSortedNumbers()
        assertEquals(sortedNumbers, sortedSetOf(3, 5, 12, 19, 24, 45))
    }

    @Test
    fun `LottoTicket이 1~45사이 번호를 가짐`() {
        //when
        val lottoTicket = LottoTicket.generate()
        //then
        val sortedNumbers = lottoTicket.getSortedNumbers()
        assertEquals(6, sortedNumbers.size)
        //then
        assertTrue(sortedNumbers.all { it in 1..45 })
    }
}
