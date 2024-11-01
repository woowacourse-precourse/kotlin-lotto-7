package lotto.model

import lotto.util.ExceptionConstants.ERROR_MESSAGE_WINNING_NUMBER_DUPLICATE
import lotto.util.ExceptionConstants.ERROR_MESSAGE_WINNING_NUMBER_RANGE
import lotto.util.ExceptionConstants.ERROR_MESSAGE_WINNING_NUMBER_SIZE
import lotto.util.ExceptionConstants.ERROR_MESSAGE_WINNING_NUMBER_TYPE
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
            .hasMessage(ERROR_MESSAGE_WINNING_NUMBER_SIZE)
    }

    @Test
    fun `당첨 번호가 숫자가 아니면 예외가 발생한다`() {
        val rawWinningNumbers = "1,2,3,4,5,abc"
        val winningNumber = WinningNumber()

        assertThatThrownBy { winningNumber.setWinningNumbers(rawWinningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ERROR_MESSAGE_WINNING_NUMBER_TYPE)
    }

    @Test
    fun `당첨 번호에 중복이 있으면 예외가 발생한다`() {
        val rawWinningNumbers = "1,2,3,4,5,5"
        val winningNumber = WinningNumber()

        assertThatThrownBy { winningNumber.setWinningNumbers(rawWinningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ERROR_MESSAGE_WINNING_NUMBER_DUPLICATE)
    }

    @Test
    fun `당첨 번호가 1~45 사이가 아니면 예외가 발생한다`() {
        val rawWinningNumbers = "0,2,3,4,5,6"
        val winningNumber = WinningNumber()

        assertThatThrownBy { winningNumber.setWinningNumbers(rawWinningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ERROR_MESSAGE_WINNING_NUMBER_RANGE)
    }
}
