package lotto.utils

import lotto.model.message.ErrorMessage
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidationUtilsTest {

    @Test
    fun `구매 금액이 1,000원 단위 입력일 때 정상출력`() {
        // given
        val validAmounts = listOf(1000, 2000, 3000)

        // when & then
        validAmounts.forEach { amount ->
            ValidationUtils.validatePurchaseAmount(amount)
        }
    }

    @Test
    fun `구매 금액이 1,000원 단위 입력이 아닐 시 예외`() {
        // given
        val invalidAmount = 1500

        // when & then
        val exception = assertThrows<IllegalArgumentException> {
            ValidationUtils.validatePurchaseAmount(invalidAmount)
        }
        assertEquals(ErrorMessage.PURCHASE_PRICE_1000.message, exception.message)
    }

    @Test
    fun `번호가 유효할 때 정상출력 `() {
        // given
        val validInput = "5"

        // when
        val result = ValidationUtils.validateWinningNumberInput(validInput)

        // then
        assertEquals(5, result)
    }

    @Test
    fun `번호가 빈 입력일 때 예외`() {
        // given
        val emptyInput = ""

        // when & then
        val exception = assertThrows<IllegalArgumentException> {
            ValidationUtils.validateWinningNumberInput(emptyInput)
        }
        assertEquals(ErrorMessage.INPUT_WINNING_EMPTY.message, exception.message)
    }

    @Test
    fun `번호가 숫자가 아닌 입력일 때 예외`() {
        // given
        val invalidInput = "abc"

        // when & then
        val exception = assertThrows<IllegalArgumentException> {
            ValidationUtils.validateWinningNumberInput(invalidInput)
        }
        assertEquals(ErrorMessage.INVALID_NUMBER_FORMAT.message, exception.message)
    }
}
