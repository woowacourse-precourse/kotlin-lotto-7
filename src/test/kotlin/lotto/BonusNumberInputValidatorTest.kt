package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberInputValidatorTest {
    val inputValidator = InputValidator()

    @Test
    fun 입력_올바른_보너스_번호일_때_성공() {
        val winningNumbers = listOf(1, 3, 5, 7, 9, 11)
        val bonusNumber = "13"
        val result = inputValidator.validateBonusNumber(bonusNumber, winningNumbers)
        assertEquals(13, result)
    }

    @Test
    fun 입력_보너스_번호가_당첨번호와_중복될_때_오류_출력() {
        val winningNumbers = listOf(1, 3, 5, 7, 9, 11)
        val bonusNumber = "5"
        val exception = assertThrows<IllegalArgumentException> {
            inputValidator.validateBonusNumber(bonusNumber, winningNumbers)
        }
        assertEquals(InputValidator.ERROR_DUPLICATE_BONUS_NUMBER, exception.message)
    }

    @Test
    fun 입력_보너스_번호가_범위를_벗어날_때_오류_출력() {
        val winningNumbers = listOf(1, 3, 5, 7, 9, 11)
        val bonusNumber = "50"
        val exception = assertThrows<IllegalArgumentException> {
            inputValidator.validateBonusNumber(bonusNumber, winningNumbers)
        }
        assertEquals(InputValidator.ERROR_INVALID_WINNING_NUMBER_RANGE, exception.message)
    }
}