package lotto

import lotto.Util.Validator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidatorTest {
    @Test
    fun `구매 금액이 1000원 단위가 아닐 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Validator.validatePurchaseInput("1500")
        }
    }

    @Test
    fun `구매 금액이 숫자가 아닐 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Validator.validatePurchaseInput("abcd")
        }
    }
}