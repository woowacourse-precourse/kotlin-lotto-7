package exception

import validation.InputValidation
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import utils.LottoUtils

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

    @ParameterizedTest
    @CsvSource("1, 3, 3", "1, 4, 5, 8, 24, 24")
    fun `당첨 번호는 6개의 서로 중복되지 않는 숫자로 이뤄져야 한다`(winNumbersInput: String) {
        assertSimpleTest {
            // given
            val winNumbers = winNumbersInput.split(", ")
                .map { it.trim().toInt() }

            // when

            // then
            assertThrows<IllegalArgumentException> {
                input.isValidWinNumbers(winNumbers)
            }
        }
    }

    @Test
    fun `당첨 번호는 1~45까지의 숫자이어야 한다`() {
        assertSimpleTest {
            // given
            val winNumbers = listOf(1, 3, 14, 524, 2323, 5)

            // when

            // then
            assertThrows<IllegalArgumentException> {
                input.isinValidRange(winNumbers)
            }
        }
    }
}