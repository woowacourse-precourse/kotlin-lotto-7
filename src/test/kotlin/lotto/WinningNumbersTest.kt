package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersTest {

    @Test
    fun `당첨 번호가 6자리가 아닐 경우 예외 발생 테스트`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(listOf(1, 2, 3, 4, 5, 6, 7), 3)
        }
    }

    @Test
    fun `당첨 번호의 숫자 범위가 1~45까지가 아닐 경우 예외 발생 테스트`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(listOf(0, 2, 3, 4, 5, 6), 3)
        }
    }

    @Test
    fun `당첨 번호에 중복이 있을 경우 예외 발생 테스트`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(listOf(1, 1, 3, 4, 5, 6), 3)
        }
    }

    @Test
    fun `보너스 번호의 숫자 범위가 1~45까지가 아닐 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(listOf(2, 3, 4, 5, 6, 7), 0)
        }
    }

    @Test
    fun `보너스 번호의 숫자가 당첨 번호와 중복이 있을 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(listOf(2, 3, 4, 5, 6, 7), 3)
        }
    }

}