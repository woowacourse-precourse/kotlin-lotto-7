package lotto

import lotto.domain.Lotto
import lotto.domain.PurchaseAmount
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchaseAmountTest {
    @Test
    fun `구입 금액이 1000의 배수가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            PurchaseAmount(12345)
        }
    }

    @Test
    fun `구입 금액이 1000원 미만인 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            PurchaseAmount(500)
        }
    }
}