package lotto

import lotto.domain.entity.BonusNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberTest {

    @Test
    fun `당첨 번호들에 보너스 번호가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber(number = 1, winningNumbers =  listOf(1, 2, 3, 4, 7, 5))
        }
    }

    @Test
    fun `보너스 번호가 1보다 작을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber(number = 0, winningNumbers =  listOf(8, 2, 3, 4, 9, 5))
        }
    }

    @Test
    fun `보너스 번호가 45보다 클 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber(number = 46, winningNumbers =  listOf(8, 2, 3, 4, 9, 5))
        }
    }
}