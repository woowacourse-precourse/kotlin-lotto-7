package lotto

import lotto.model.WinningNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumberTest {
    @Test
    fun `WinningNumber에 중복된 숫자가 있으면 예외가 발생(1)`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `WinningNumber에 중복된 숫자가 있으면 예외가 발생(2)`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber(listOf(1, 2, 3, 4, 5, 6, 6))
        }
    }

    @Test
    fun `WinningNumber에 8숫자가 들어갔을때의 예외 상황`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber(listOf(1, 2, 3, 4, 5, 6, 7, 8))
        }
    }
}