package lotto

import lotto.util.ConstantsUtil.DELIMITER_COMMA
import lotto.util.ValidatorUtil
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningLottoTest {

    @Test
    fun `당첨 번호가 숫자가 아닐 경우 예외가 발생한다`() {
        val input = "1,2,3,4,5,?"
        val inputWinningNumbers =  input.split(DELIMITER_COMMA).map { it.toIntOrNull() }
        assertThrows<IllegalArgumentException> {
            ValidatorUtil.validateWinningNumbers(inputWinningNumbers)
        }
    }

    @Test
    fun `당첨 번호가 중복일 경우 예외가 발생한다`() {
        val input = "1,2,3,4,5,5"
        val inputWinningNumbers =  input.split(DELIMITER_COMMA).map { it.toIntOrNull() }.filterNotNull()
        assertThrows<IllegalArgumentException> {
            ValidatorUtil.validateUniqueWinningNumbers(inputWinningNumbers)
        }
    }

    @Test
    fun `당첨 번호 6개가 넘어가면 예외가 발생한다`() {
        val input = "1,2,3,4,5,6,7"
        val inputWinningNumbers =  input.split(DELIMITER_COMMA).map { it.toIntOrNull() }.filterNotNull()
        assertThrows<IllegalArgumentException> {
            ValidatorUtil.validateWinningNumbersSize(inputWinningNumbers.size)
        }
    }

    @Test
    fun `당첨 번호 6개보다 적으면 예외가 발생한다`() {
        val input = "1,2,3,4,5"
        val inputWinningNumbers =  input.split(DELIMITER_COMMA).map { it.toIntOrNull() }.filterNotNull()
        assertThrows<IllegalArgumentException> {
            ValidatorUtil.validateWinningNumbersSize(inputWinningNumbers.size)
        }
    }

    @Test
    fun `당첨 번호 범위가 1~45 사이가 아니라면 예외가 발생한다`() {
        val input = "1,2,3,4,5,99"
        val inputWinningNumbers =  input.split(DELIMITER_COMMA).map { it.toIntOrNull() }.filterNotNull()
        assertThrows<IllegalArgumentException> {
            ValidatorUtil.validateWinningNumbersRange(inputWinningNumbers)
        }
    }
}