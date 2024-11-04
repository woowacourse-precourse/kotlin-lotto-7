package lotto

import lotto.util.ConstantsUtil.DELIMITER_COMMA
import lotto.util.ValidatorUtil
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusLottoTest {

    @Test
    fun `보너스 번호가 숫자가 아닐 경우 예외가 발생한다`() {
        val input = "?"
        assertThrows<IllegalArgumentException> {
            ValidatorUtil.validateBonusNumber(input)
        }
    }

    @Test
    fun `보너스 번호 범위가 1~45 사이가 아니라면 예외가 발생한다`() {
        val input = 99
        assertThrows<IllegalArgumentException> {
            ValidatorUtil.validateBonusNumberRange(input)
        }
    }

    @Test
    fun `보너스 번호와 당첨 번호가 중복일 때 예외가 발생한다`() {
        val bonusInput = 5
        val winningInput = listOf(1,2,3,4,5,6)
        assertThrows<IllegalArgumentException> {
            ValidatorUtil.validateBonusNumberNotInWinningNumbers(winningInput, bonusInput)
        }
    }
}