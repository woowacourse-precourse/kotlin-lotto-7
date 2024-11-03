package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {

    @Test
    fun `buyTickets()가 지불한 금액에 따라 올바른 수의 티켓을 생성한다`() {
        val lotto = Lotto(listOf())
        val payment = 5000
        val ticketList = lotto.buyTickets(payment)

        // 5개의 티켓이 생성되는지 확인
        assertEquals(5, ticketList.size)
    }

    @Test
    fun `generateTicketRandomly()가 중복되지 않은 6개의 번호를 생성한다`() {
        val lotto = Lotto(listOf())
        val ticket = lotto.buyTickets(1000).first()

        println(ticket)
        // 생성된 티켓의 번호 개수 확인
        assertEquals(6, ticket.size)

        // 번호 범위 확인
        assertTrue(ticket.all { it in 1..45 })

        // 번호의 중복 여부 확인
        assertEquals(ticket.distinct().size, ticket.size)
    }

//    @Test
//    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
//        assertThrows<IllegalArgumentException> {
//            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
//        }
//    }
//
//    // TODO: 테스트가 통과하도록 프로덕션 코드 구현
//    @Test
//    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
//        assertThrows<IllegalArgumentException> {
//            Lotto(listOf(1, 2, 3, 4, 5, 5))
//        }
//    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
}
