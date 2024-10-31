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

    @Test
    fun `Purchase 객체가 살 수 있는 로또 개수를 확인할 수 있다`() {
        // given
        val input = "15000"
        val expected = 15

        // when
        val purchase = Purchase.valueOf(input)

        // then
        assertEquals(expected, purchase.getNumberOfLotto())
    }
}