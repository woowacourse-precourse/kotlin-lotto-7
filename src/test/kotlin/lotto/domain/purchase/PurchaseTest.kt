package lotto.domain.purchase

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PurchaseTest {

    @Test
    fun `valueOf 메서드의 인자로 받은 값은 getAmount() 메서드로 확인할 수 있다`() {
        // given
        val input = "10000"
        val expected = 10_000

        // when
        val purchase = Purchase.valueOf(input)

        // then
        assertEquals(expected, purchase.getAmount())
    }
}