package lotto

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LottoManagerTest {

    @Test
    fun `buyTickets()가 지불한 금액에 따라 올바른 수의 티켓을 생성한다`() {

        val payment = 5000
        val ticketList = LottoManager.buyTickets(payment)

        // 5개의 티켓이 생성되는지 확인
        assertEquals(5, ticketList.size)
    }

    @Test
    fun `generateTicketRandomly()가 중복되지 않은 6개의 번호를 생성한다`() {
        val ticket = LottoManager.buyTickets(1000).first()

        println(ticket)
        // 생성된 티켓의 번호 개수 확인
        assertEquals(6, ticket.size)

        // 번호 범위 확인
        assertTrue(ticket.all { it in 1..45 })

        // 번호의 중복 여부 확인
        assertEquals(ticket.distinct().size, ticket.size)
    }

    @Test
    fun `getLottoResultAsRank가 올바른 등수를 반환한다`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val firstPrizeTicket = listOf(1, 2, 3, 4, 5, 6)
        val secondPrizeTicket = listOf(1, 2, 3, 4, 5, 7)
        val thirdPrizeTicket = listOf(1, 2, 3, 4, 5, 45)
        val fourthPrizeTicket = listOf(1, 2, 3, 4, 44, 45)
        val fifthPrizeTicket = listOf(1, 2, 3, 43, 44, 45)
        val nonePrizeTicket = listOf(1, 2, 42, 43, 44, 45)
        assertEquals(
            1,
            Lotto(firstPrizeTicket).getLottoResultAsRank(winningNumbers, bonusNumber)
        )
        assertEquals(
            2,
            Lotto(secondPrizeTicket).getLottoResultAsRank(winningNumbers, bonusNumber)
        )
        assertEquals(
            3,
            Lotto(thirdPrizeTicket).getLottoResultAsRank(winningNumbers, bonusNumber)
        )
        assertEquals(
            4,
            Lotto(fourthPrizeTicket).getLottoResultAsRank(winningNumbers, bonusNumber)
        )
        assertEquals(
            5,
            Lotto(fifthPrizeTicket).getLottoResultAsRank(winningNumbers, bonusNumber)
        )
        assertEquals(
            6,
            Lotto(nonePrizeTicket).getLottoResultAsRank(winningNumbers, bonusNumber)
        )
    }
}