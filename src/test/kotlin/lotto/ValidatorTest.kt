package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import lotto.view.Validator

class ValidatorTest {
    private val validator = Validator()

    @Test
    fun `8145060000보다 큰 숫자면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validatePayment("8145060001")
        }
    }

    @Test
    fun `음수면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validatePayment("-1")
        }
    }

    @Test
    fun `Long 범위를 초과하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validatePayment("9223372036854775808")
        }
    }

}
