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

    @Test
    fun `당첨 번호에 공백이 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateWinningNumbers("1, 2, 3, 4, 5, 6")
        }
    }

    @Test
    fun `당첨 번호에 빈 값이 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateWinningNumbers("1, 2, 3, 4, 5, ")
        }
    }

    @Test
    fun `당첨 번호 중복이 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateWinningNumbers("1, 2, 3, 4, 5, 5")
        }
    }

    @Test
    fun `각 당첨 번호가 지정된 숫자 범위에 포함되어 있지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateWinningNumbers("1, 2, 3, 4, 5, 46")
        }
    }

    @Test
    fun `당첨 번호 개수가 6개보다 작으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateWinningNumbers("1, 2, 3, 4, 5")
        }
    }

    @Test
    fun `당첨 번호 개수가 6개보다 크면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateWinningNumbers("1, 2, 3, 4, 5, 6, 7")
        }
    }

    @Test
    fun `보너스 번호와 당첨 번호가 중복되면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateBonusNumber("1", listOf(1, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `보너스 번호가 지정된 숫자 범위에 포함되어 있지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateBonusNumber("46", listOf(1, 2, 3, 4, 5, 6))
        }
    }
}