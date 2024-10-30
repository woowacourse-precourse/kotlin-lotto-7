package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import lotto.view.Validator

class ValidatorTest {
    private val validator = Validator()

    @Test
    fun `음수면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validatePayment("-1")
        }
    }

    @Test
    fun `2,000,000,000을 초과하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validatePayment("2000000001")
        }
    }
}
