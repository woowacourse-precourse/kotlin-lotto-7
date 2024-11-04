package lotto

import lotto.domain.entity.Lotto
import lotto.domain.entity.User
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UserTest {
    private lateinit var user: User

    @BeforeEach
    fun setUp() {
        user = User(3_000)
    }

    @Test
    fun `로또 구매하는 기능 테스트`() {
        val lottoTickets = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(1, 2, 3, 4, 5, 7)))
        user.buyLottoTickets { lottoTickets }
        val result = user.getLottoTickets()
        assertEquals(lottoTickets, result)
    }

    @Test
    fun `로또를 구매하지 않고 로또 티켓들을 호출할때 State 예외 발생 테스트`() {
        assertThrows<IllegalStateException> { user.getLottoTickets() }
    }

    @Test
    fun `1000원에 나누어 떨어지지 않으면 예외 발생 테스트`() {
        assertThrows<IllegalArgumentException> {
            User(4_001)
        }
    }

    @Test
    fun `돈이 마이너스일 경우 예외 발생 테스트`() {
        assertThrows<IllegalArgumentException> {
            User(-1_000)
        }
    }
}