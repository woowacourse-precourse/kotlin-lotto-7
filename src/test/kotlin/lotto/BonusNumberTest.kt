package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberTest {

    @Test
    fun `보너스 번호가 1~45 사이의 수가 아닐 경우 예외가 발생한다`() {
        val bonusNumber = 46

        assertThrows<IllegalArgumentException> {
            BonusNumber(bonusNumber)
        }
    }
}