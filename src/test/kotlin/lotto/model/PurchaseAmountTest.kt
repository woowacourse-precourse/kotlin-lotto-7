package lotto.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchaseAmountTest {
    @Test
    fun `구입 금액이 1000원 미만이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            PurchaseAmount(999)
        }
    }

    @Test
    fun `구입 금액이 1000원 단위가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            PurchaseAmount(1001)
        }
    }
}
