package lotto.validation

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Test

class InputValidatorTest {

    @Test
    fun `구입 금액이 1000원 미만이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validatePurchaseAmount("999")
        }
    }

    @Test
    fun `구입 금액이 1000원 단위가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validatePurchaseAmount("1500")
        }
    }

    @Test
    fun `구입 금액에 공백이 포함되어 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validatePurchaseAmount("1 000")
        }
    }

    @Test
    fun `아무런 금액을 입력하지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validatePurchaseAmount("")
        }
    }

    @Test
    fun `최대 구매 가능 금액을 초과하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validatePurchaseAmount("1001000")
        }
    }

    @Test
    fun `구입 금액에 문자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validatePurchaseAmount("1000a")
        }
    }
}