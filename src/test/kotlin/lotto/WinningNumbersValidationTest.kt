package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import utils.WinningNumbersValidator

class WinningNumbersValidationTest {
    @Test
    fun `당첨 번호는 6개이어야 한다`() {
        val winningNumbers = "1,2,3,4,5".split(",")

        assertThrows<IllegalArgumentException> {
            WinningNumbersValidator.SHOULD_BE_SIX_COUNT.validate(winningNumbers)
        }
    }

    @Test
    fun `당첨 번호는 숫자로 이루어져야 한다`() {
        val winningNumbers = "1,2,3,4,5,당첨".split(",")

        assertThrows<IllegalArgumentException> {
            WinningNumbersValidator.SHOULD_BE_NUMBER.validate(winningNumbers)
        }
    }

    @Test
    fun `당첨 번호는 1~45 사이어야 한다`() {
        val winningNumbers = "1,2,3,4,5,46".split(",")

        assertThrows<IllegalArgumentException> {
            WinningNumbersValidator.SHOULD_BE_1_TO_45_NUMBER.validate(winningNumbers)
        }
    }

    @Test
    fun `당첨 번호는 중복되면 안된다`() {
        val winningNumbers = "1,2,3,4,5,5".split(",")

        assertThrows<IllegalArgumentException> {
            WinningNumbersValidator.SHOULD_NOT_BE_DUPLICATE.validate(winningNumbers)
        }
    }
}