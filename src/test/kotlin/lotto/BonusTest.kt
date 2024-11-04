package lotto

import lotto.model.BonusNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusTest {
    @Test
    fun `로또 번호에 보너스 번호와 중복되는 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber("2", listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `보너스 번호의 숫자가 1~45 범위에 들어가지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber("46", listOf(1, 2, 3, 4, 5, 5))
        }
    }
}