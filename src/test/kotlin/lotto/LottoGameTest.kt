package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LottoGameTest {
    private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
    private val bonusNumber = 7

    @Test
    fun `buyTickets()가 지불한 금액에 따라 올바른 수의 티켓을 생성한다`() {

        val payment = 5000
        val lottoGame = LottoGame(winningNumbers, bonusNumber)
        lottoGame.buyTickets(payment)

        // 5개의 티켓이 생성되는지 확인
        assertEquals(5, lottoGame.ticketList.size)
    }

    @Test
    fun `generateTicketRandomly()가 중복되지 않은 6개의 번호를 생성한다`() {
        val lottoGame = LottoGame(winningNumbers, bonusNumber)
        lottoGame.buyTickets(1000)
        val numberList = lottoGame.ticketList.first().getNumbers()

        // 생성된 티켓의 번호 개수 확인
        assertEquals(6, numberList.size)

        // 번호 범위 확인
        assertTrue(numberList.all { it in 1..45 })

        // 번호의 중복 여부 확인
        assertEquals(numberList.distinct().size, numberList.size)
    }
}