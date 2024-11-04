package ExceptionTest

import Validation.InputValidation
import View.InputView
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class InputExceptionTest {
    private val input = InputValidation()

    @Test
    fun `로또 구입 금액은 1,000원 단위이어야 한다`() {
        assertSimpleTest {
            // given
            val money = 365

            // when


            // then
            assertThrows<IllegalArgumentException> {
                input.isValidMoney(money)
            }
        }
    }

    @ParameterizedTest
    @CsvSource("-1", "abc", "' '", "\\n", "''", "0")
    fun `로또 구입 금액은 양의 정수이어야 한다`(moneyInput: String) {
        assertSimpleTest {
            // given
            val money = moneyInput.toIntOrNull()?: 0

            // when

            // then
            assertThrows<IllegalArgumentException> {
                input.isValidMoney(money)
            }
        }
    }
}