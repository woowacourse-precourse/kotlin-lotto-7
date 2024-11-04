package lotto

import lotto.model.PurchaseAmount
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchaseAmountTest {
    @Test
    fun `구매 금액이 1000단위로 나누어 떨어지지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            PurchaseAmount(7900)
        }
    }

    @Test
    fun `구매 금액이 0 또는 음수일 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            PurchaseAmount(-1)
            PurchaseAmount(0)
        }
    }
}