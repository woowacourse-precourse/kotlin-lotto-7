package lotto.domain.purchase

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PurchaseTest {

    @Test
    fun `valueOf 메서드의 인자로 받은 값은 생성된 Purchase 인스턴스의 amount 필드값과 동일하다`() {
        // given
        val input = "10000"
        val expected = 10_000

        // when
        val purchase = Purchase.valueOf(input)

        // then
        assertEquals(expected, purchase.amount)
    }
}