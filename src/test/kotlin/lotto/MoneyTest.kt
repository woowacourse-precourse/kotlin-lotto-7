package lotto

import lotto.model.Money
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MoneyTest {

    @Test
    fun `금액이 0 이하일 때 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Money(0)
        }
    }

    @Test
    fun `금액이 음수일 때 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Money(-1000)
        }
    }

    @Test
    fun `금액이 1000원 단위가 아닐 때 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Money(1500)
        }
    }

    @Test
    fun `올바른 금액일 때 예외가 발생하지 않는다`() {
        Money(1000)
        Money(2000)
    }
}
