package lotto.data

import lotto.core.TICKET_PRICE
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchaseAmountTest {
    @Test
    fun `구입금액이 음수면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            PurchaseAmount("-1000", TICKET_PRICE)
        }
    }

    @Test
    fun `구입금액이 숫자가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            PurchaseAmount("abc", TICKET_PRICE)
        }
    }

    @Test
    fun `구입금액이 0원일 때 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            PurchaseAmount("0", TICKET_PRICE)
        }
    }

    @Test
    fun `구입금액이 티켓 가격으로 나누어 떨어지지 않을 때 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            PurchaseAmount("1500", TICKET_PRICE)
        }
    }

    @Test
    fun `정상 케이스`() {
        val purchaseAmount = PurchaseAmount("5000", TICKET_PRICE)
        assertEquals(5000, purchaseAmount.getAmount())
    }

}