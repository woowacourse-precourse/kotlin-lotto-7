package lotto

import lotto.manager.BonusNumberManager
import lotto.model.Lotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberManagerTest {
    private val bonusNumberManager = BonusNumberManager(Lotto(listOf(1, 2, 3, 4, 5, 6)))

    @Test
    fun `숫자가 아닌 문자를 입력하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            bonusNumberManager.validateBonusNumberInput("a")
        }
    }

    @Test
    fun `보너스 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            bonusNumberManager.validateBonusNumberInput("46")
        }
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복되면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            bonusNumberManager.validateBonusNumberInput("6")
        }
    }
}