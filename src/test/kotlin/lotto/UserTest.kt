package lotto

import lotto.domain.entity.User
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UserTest {
    private lateinit var user: User

    @BeforeEach
    fun setUp() {
        user = User(3000)
    }

    @Test
    fun `1000원에 나누어 떨어지도록 로또를 구매하는 기능 테스트`() {
        val result = user.getLottoTickets().size
        val expect = 3
        assertEquals(expect, result)
    }

    @Test
    fun `1000원에 나누어 떨어지지 않으면 예외 발생 테스트`() {
        assertThrows<IllegalArgumentException> {
            User(4001)
        }
    }

    @Test
    fun `돈이 마이너스일 경우 예외 발생 테스트`() {
        assertThrows<IllegalArgumentException> {
            User(-1000)
        }
    }
}