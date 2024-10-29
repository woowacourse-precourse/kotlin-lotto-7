package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MoneyTest {

    @Test
    fun `돈이 정상적으로 생성된다`() {
        Money(1_000)
    }

    @Test
    fun `돈이 0원인 경우 생성되지 않는다`() {
        assertThrows<IllegalArgumentException> {
            Money(0)
        }
    }

    @Test
    fun `돈이 마이너스인 경우 생성되지 않는다`() {
        assertThrows<IllegalArgumentException> {
            Money(-1_000)
        }
    }
}
