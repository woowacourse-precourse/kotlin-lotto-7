package lotto

import lotto.domain.PurchaseAmount
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchaseAmountTest {
    @Test
    fun `로또 구입 금액이 0 이하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            PurchaseAmount(-1000)
        }
    }

    @Test
    fun `로또 구입 금액이 1000원 단위가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            PurchaseAmount(100)
        }
    }

    @Test
    fun `로또 구입 금액에 대한 발행한 로또 수량 확인`() {
        val purchaseAmount = PurchaseAmount(8000)
        assert(purchaseAmount.getCount() == 8)
    }
}