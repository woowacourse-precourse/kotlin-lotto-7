package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchaseAmountInputValidatorTest {
    @Test
    fun 입력_금액이_1000원으로_나누어떨어질_때_입력통과() {
        val purchaseAmount = "5000"
        val result = InputValidator().validatePurchaseAmount(purchaseAmount)

        assertEquals(5000, result)
    }

    @Test
    fun 입력_금액이_1000원으로_나누어떨어지지_않을_때_오류_출력() {
        val purchaseAmount = "5500"
        val exception = assertThrows<IllegalArgumentException> {
            InputValidator().validatePurchaseAmount(purchaseAmount)
        }

        assertEquals(InputValidator.ERROR_INVALID_PURCHASE_AMOUNT_UNIT, exception.message)
    }

    @Test
    fun 입력_금액이_0일_때_오류_출력() {
        val purchaseAmount = "0"
        val exception = assertThrows<IllegalArgumentException> {
            InputValidator().validatePurchaseAmount(purchaseAmount)
        }

        assertEquals(InputValidator.ERROR_INVALID_PURCHASE_AMOUNT_NONPOSITIVE, exception.message)
    }

    @Test
    fun 입력_금액이_숫자가_아닐_때_오류_출력() {
        val purchaseAmount = "abc"
        val exception = assertThrows<IllegalArgumentException> {
            InputValidator().validatePurchaseAmount(purchaseAmount)
        }

        assertEquals(InputValidator.ERROR_INVALID_PURCHASE_AMOUNT_FORMAT, exception.message)
    }
}