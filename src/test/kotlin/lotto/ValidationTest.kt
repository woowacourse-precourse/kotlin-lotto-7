package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import utils.Validator

class ValidationTest {
    @Test
    fun `구입 금액은 숫자 형태이어야 한다`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateMoney("구입금액")
        }
    }

    @Test
    fun `구입 금액은 양수이어야 한다`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateMoney("-1000")
        }
    }

    @Test
    fun `구입 금액은 1,000원 단위로 나누어 떨어져야 한다`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateMoney("1001")
        }
    }

    @Test
    fun `0원도 허용한다`() {
        assertDoesNotThrow {
            Validator.validateMoney("0")
        }
    }
}