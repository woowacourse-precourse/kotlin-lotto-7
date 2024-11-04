package lotto

import lotto.view.Bonus
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusTest {
    @Test
    fun `보너스 번호가 음수이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Bonus(-1)
        }
    }

    @Test
    fun `보너스 번호가 0이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Bonus(0)
        }
    }

    @Test
    fun `보너스 번호가 45를 초과하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Bonus(46)
        }
    }
}