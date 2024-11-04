package lotto

import lotto.model.WinningNumbers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersTest {

    @Test
    fun `보너스 번호가 당첨 번호와 중복될 때 예외가 발생한다`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 5

        assertThrows<IllegalArgumentException> {
            WinningNumbers(winningNumbers, bonusNumber)
        }
    }

    @Test
    fun `보너스 번호가 1~45 범위를 벗어날 때 예외가 발생한다`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        assertThrows<IllegalArgumentException> {
            WinningNumbers(winningNumbers, 0)  // 0은 범위 밖
        }

        assertThrows<IllegalArgumentException> {
            WinningNumbers(winningNumbers, 46)  // 46은 범위 밖
        }
    }

    @Test
    fun `정상적인 보너스 번호일 때 예외가 발생하지 않는다`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        WinningNumbers(winningNumbers, bonusNumber)  // 예외가 발생하지 않아야 함
    }
}
