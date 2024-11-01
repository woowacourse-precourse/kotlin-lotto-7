package lotto.model

import lotto.model.WinningNumber.Companion.NUMBER_DUPLICATE_MESSAGE
import lotto.model.WinningNumber.Companion.NUMBER_RANGE_MESSAGE
import lotto.model.WinningNumber.Companion.NUMBER_SIZE_MESSAGE
import lotto.model.WinningNumber.Companion.NUMBER_TYPE_MESSAGE
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WinningNumberTest {

    @Test
    fun `당첨 번호를 정상적으로 설정하면 성공한다`() {
        val rawWinningNumbers = "1,2,3,4,5,6"
        val winningNumber = WinningNumber()

        winningNumber.setWinningNumbers(rawWinningNumbers)

        assertEquals(listOf(1, 2, 3, 4, 5, 6), winningNumber.getWinningNumbers())
    }

    @Test
    fun `당첨 번호에 공백이 포함되어도 정상적으로 처리한다`() {
        val rawWinningNumbers = "1, 2, 3, 4, 5, 6"
        val winningNumber = WinningNumber()

        winningNumber.setWinningNumbers(rawWinningNumbers)

        assertEquals(listOf(1, 2, 3, 4, 5, 6), winningNumber.getWinningNumbers())
    }

    @Test
    fun `당첨 번호가 6개가 아니면 예외가 발생한다`() {
        val rawWinningNumbers = "1,2,3,4,5"
        val winningNumber = WinningNumber()

        assertThatThrownBy { winningNumber.setWinningNumbers(rawWinningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(NUMBER_SIZE_MESSAGE)
    }

    @Test
    fun `당첨 번호가 숫자가 아니면 예외가 발생한다`() {
        val rawWinningNumbers = "1,2,3,4,5,abc"
        val winningNumber = WinningNumber()

        assertThatThrownBy { winningNumber.setWinningNumbers(rawWinningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(NUMBER_TYPE_MESSAGE)
    }

    @Test
    fun `당첨 번호에 중복이 있으면 예외가 발생한다`() {
        val rawWinningNumbers = "1,2,3,4,5,5"
        val winningNumber = WinningNumber()

        assertThatThrownBy { winningNumber.setWinningNumbers(rawWinningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(NUMBER_DUPLICATE_MESSAGE)
    }

    @Test
    fun `당첨 번호가 1~45 사이가 아니면 예외가 발생한다`() {
        val rawWinningNumbers = "0,2,3,4,5,6"
        val winningNumber = WinningNumber()

        assertThatThrownBy { winningNumber.setWinningNumbers(rawWinningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(NUMBER_RANGE_MESSAGE)
    }
}
