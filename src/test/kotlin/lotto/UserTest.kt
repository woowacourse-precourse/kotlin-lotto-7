package lotto

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
        user.buy()
        val result = user.lottos.size
        val expect = 3
        assertEquals(expect, result)
    }
}