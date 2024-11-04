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

    @Test
    fun `당첨 번호가 1 ~ 45의 범위가 아닌 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateWinningNumbers(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `당첨 번호에 중복된 숫자가 있을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateWinningNumbers(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateBonusNumber(5, listOf(1, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `보너스 번호가 1 ~ 45 범위를 벗어나면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateBonusNumber(46, listOf(1, 2, 3, 4, 5, 6))
        }
    }
}