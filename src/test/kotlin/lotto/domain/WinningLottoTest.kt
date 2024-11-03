package lotto.domain

import lotto.util.Constants
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningLottoTest {

    @Test
    fun `당첨 번호의 개수가 6개가 아니면 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5), 6)
        }
        assertEquals(Constants.ERROR_INVALID_WINNING_NUMBERS_SIZE, exception.message)
    }

    @Test
    fun `당첨 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 5), 6)
        }
        assertEquals(Constants.ERROR_DUPLICATE_NUMBER, exception.message)
    }

    @Test
    fun `당첨 번호의 숫자가 1부터 45 사이가 아니면 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(0, 2, 3, 4, 5, 6), 7)
        }
        assertEquals(Constants.ERROR_NUMBER_OUT_OF_RANGE, exception.message)
    }

    @Test
    fun `보너스 번호의 숫자가 1부터 45 사이가 아니면 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 6), 46)
        }
        assertEquals(Constants.ERROR_NUMBER_OUT_OF_RANGE, exception.message)
    }

    @Test
    fun `입력받은 당첨 번호와 보너스 번호가 중복되면 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 6), 6)
        }
        assertEquals(Constants.ERROR_BONUS_NUMBER_DUPLICATE, exception.message)
    }

    @Test
    fun `당첨 번호와 보너스 번호가 정상적이면 WinningLotto 객체가 생성된다`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        assertEquals(listOf(1, 2, 3, 4, 5, 6), winningLotto.getWinningNumbers())
        assertEquals(7, winningLotto.getBonusNumber())
    }
}
