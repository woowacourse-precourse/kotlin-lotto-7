package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumberInputValidatorTest {
    val inputValidator = InputValidator()

    @Test
    fun 입력_올바른_당첨_번호일_때_성공() {
        val winningNumbers = "1, 3, 5, 7, 9, 11"
        val result = inputValidator.validateWinningNumbers(winningNumbers)
        assertEquals(listOf(1, 3, 5, 7, 9, 11), result)
    }

    @Test
    fun 입력_중복된_번호가_포함될_때_오류_출력() {
        val winningNumbers = "1, 3, 3, 7, 9, 11"
        val exception = assertThrows<IllegalArgumentException> {
            inputValidator.validateWinningNumbers(winningNumbers)
        }
        assertEquals(InputValidator.ERROR_DUPLICATE_WINNING_NUMBERS, exception.message)
    }

    @Test
    fun 입력_번호가_범위를_벗어날_때_오류_출력() {
        val winningNumbers = "1, 3, 5, 7, 9, 46"
        val exception = assertThrows<IllegalArgumentException> {
            inputValidator.validateWinningNumbers(winningNumbers)
        }
        assertEquals(InputValidator.ERROR_INVALID_WINNING_NUMBER_RANGE, exception.message)
    }

    @Test
    fun 입력_쉼표없이_당첨번호를_입력할_때_오류_출력() {
        val winningNumbers = "1 3 5 7 9 11"
        val exception = assertThrows<IllegalArgumentException> {
            inputValidator.validateWinningNumbers(winningNumbers)
        }
        assertEquals(InputValidator.ERROR_INVALID_WINNING_NUMBERS_COUNT, exception.message)
    }
}