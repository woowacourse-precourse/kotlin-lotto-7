package ExceptionTest

import Validation.InputValidation
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class InputExceptionTest {
    private val input = InputValidation()
    @ParameterizedTest
    @CsvSource("1_000, true", "365, false")
    fun `로또 구입 금액은 1,000원 단위이어야 한다`(money: Int, expected: Boolean) {
        assertSimpleTest {
            // given

            // when
            val result = input.isValidUnit(money)

            // then
            assertThat(result).isEqualTo(expected)
        }
    }
}