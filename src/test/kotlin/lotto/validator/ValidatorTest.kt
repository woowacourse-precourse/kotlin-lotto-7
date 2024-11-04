package lotto.validator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidatorTest {

    private val validator = Validator()

    @Test
    fun `구매 금액이 로또 단위 금액이 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validatePurchaseAmount(1500.toString())
        }
    }

    @Test
    fun `구매 금액이 0일 때 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validatePurchaseAmount(0.toString())
        }
    }

    @Test
    fun `당첨 번호의 개수가 6개가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validateWinningNumbers(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `당첨 번호가 범위를 벗어나면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validateWinningNumbers(listOf(0, 1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `당첨 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validateWinningNumbers(listOf(1, 2, 3, 3, 4, 5))
        }
    }

    @Test
    fun `보너스 번호가 범위를 벗어나면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validateBonusNumber(0, listOf(1, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복되면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validateBonusNumber(1, listOf(1, 2, 3, 4, 5, 6))
        }
    }
}