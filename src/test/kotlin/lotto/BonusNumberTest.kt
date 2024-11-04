package lotto

import lotto.domain.entity.BonusNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BonusNumberTest {

    @Test
    fun `당첨 번호들에 보너스 번호가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber(number = 1, winningNumbers = listOf(1, 2, 3, 4, 7, 5))
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 46, -10, 100])
    fun `보너스 번호가 1~45가 아닐 경우 예외가 발생한다`(bonusNumber: Int) {
        assertThrows<IllegalArgumentException> {
            BonusNumber(number = bonusNumber, winningNumbers = listOf(8, 2, 3, 4, 9, 5))
        }
    }
}