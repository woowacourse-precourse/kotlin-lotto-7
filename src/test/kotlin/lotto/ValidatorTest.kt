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

    @Test
    fun `당첨 번호가 숫자가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validatePrizeNumber(listOf("a","1","15","7","25","34"))
        }
    }

    @Test
    fun `보너스 번호가 숫자가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validateBonusNumber("a")
        }
    }

    @Test
    fun `보너스 번호가 45보다 크면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validateBonusNumber("46")
        }
    }

    @Test
    fun `보너스 번호가 0이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validateBonusNumber("0")
        }
    }

    @Test
    fun `보너스 번호가 음수면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validateBonusNumber("-1")
        }
    }

    @Test
    fun `보너스 번호가 int 범위가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validateBonusNumber("2147483648")
        }
    }
}
