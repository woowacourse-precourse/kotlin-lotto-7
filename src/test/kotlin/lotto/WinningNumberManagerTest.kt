package lotto

import lotto.manager.WinningNumberManager
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumberManagerTest {
    private val winningNumberManager = WinningNumberManager()

    @Test
    fun `숫자가 아닌 문자를 입력하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            winningNumberManager.validateWinningNumbersInput("1,2,3,4,5,a")
        }
    }

    @Test
    fun `쉼표로 구분되지 않은 숫자를 입력하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            winningNumberManager.validateWinningNumbersInput("1,2,3,4,5 6")
        }
    }
}