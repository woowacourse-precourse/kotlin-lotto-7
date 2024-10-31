package lotto.validation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import utils.validator.MoneyValidator
import utils.validator.Validator

class MoneyValidationTest {
    @Test
    fun `구입 금액은 숫자 형태이어야 한다`() {
        assertThrows<IllegalArgumentException> {
            MoneyValidator.SHOULD_BE_NUMBER.validate("구입금액")
        }
    }

    @Test
    fun `구입 금액은 양수이어야 한다`() {
        assertThrows<IllegalArgumentException> {
            MoneyValidator.SHOULD_BE_NUMBER.validate("-1000")
        }
    }

    @Test
    fun `구입 금액은 1,000원 단위로 나누어 떨어져야 한다`() {
        assertThrows<IllegalArgumentException> {
            MoneyValidator.SHOULD_BE_1000_UNIT.validate("1001")
        }
    }

    @Test
    fun `구입 금액은 Int MAX_VALUE 이하이어야 한다`() {
        assertThrows<IllegalArgumentException> {
            MoneyValidator.SHOULD_BE_UNDER_MAX.validate("$Int.MAX_VALUE")
        }
    }

    @Test
    fun `0원도 허용한다`() {
        assertDoesNotThrow {
            Validator.validateMoney("0")
        }
    }
}