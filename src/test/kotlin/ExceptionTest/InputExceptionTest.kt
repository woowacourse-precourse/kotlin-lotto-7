package ExceptionTest

import Validation.InputValidation
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class InputExceptionTest {
    private val input = InputValidation()

    @ParameterizedTest
    @CsvSource("1000, true", "365, false")
    fun `로또 구입 금액은 1,000원 단위이어야 한다`(money: Int, expected: Boolean) {
        assertSimpleTest {
            // given

            // when
            val valid = input.isValidUnit(money)

            // then
            assertThat(valid).isEqualTo(expected)
        }
    }

    @ParameterizedTest
    @CsvSource("-1", "abc", "' '", "\\n", "''", "0")
    fun `로또 구입 금액은 양의 정수이어야 한다`(moneyInput: String) {
        assertSimpleTest {
            // given
            val money = moneyInput.toIntOrNull()?: 0

            // when
            val valid = input.isValidMoney(money)

            // then
            assertThat(valid).isEqualTo(false)
        }
    }
}