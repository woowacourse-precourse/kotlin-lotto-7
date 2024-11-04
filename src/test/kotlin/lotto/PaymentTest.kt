package lotto

import lotto.view.Payment
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PaymentTest {
    @Test
    fun `2,000,000,000를 초과하는 숫자가 들어오면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Payment(2000000001)
        }
    }

    @Test
    fun `음수가 들어오면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Payment(-1)
        }
    }

    @Test
    fun `0이 들어오면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Payment(0)
        }
    }
}