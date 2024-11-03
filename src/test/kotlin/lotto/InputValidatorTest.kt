package lotto

import lotto.model.InputValidator
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class InputValidatorTest {

    @Nested
    inner class `구매 금액 테스트` {

        @ParameterizedTest
        @CsvSource("1000", "100000")
        fun `경계값 테스트 통과`(input: String) {
            assertDoesNotThrow {
                InputValidator.validatePurchaseAmount(input.toInt())
            }
        }

        @ParameterizedTest
        @CsvSource("0", "101000")
        fun `경계값 테스트 에러`(input: String) {
            assertThrows<IllegalArgumentException> {
                InputValidator.validatePurchaseAmount(input.toInt())
            }
        }

        @Test
        fun `값이 null(문자, 공백, 소수 등)이면 오류가 발생한다`() {
            assertThatThrownBy { InputValidator.validatePurchaseAmount(null) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("[ERROR] 정수형 숫자만 입력 가능합니다. 천 원 단위로 입력해주세요.")
        }

        @Test
        fun `값이 음수면 오류가 발생한다`() {
            assertThatThrownBy { InputValidator.validatePurchaseAmount(-1000) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("[ERROR] 외상은 취급하지 않습니다.")
        }

        @ParameterizedTest
        @CsvSource("100", "999", "1100", "99900")
        fun `값이 1000으로 나누어지지 않으면 오류가 발생한다`(input: String) {
            assertThrows<IllegalArgumentException> {
                InputValidator.validatePurchaseAmount(input.toInt())
            }
        }
    }

    @Nested
    inner class `보너스 번호 테스트` {

        private val winningNumber = listOf(1,2,3,4,5,6)

        @ParameterizedTest
        @CsvSource("1", "2", "3", "4", "5", "6")
        fun `보너스 번호가 당첨 번호와 일치하면 오류가 발생한다`(input: String) {
            assertThrows<IllegalArgumentException> {
                InputValidator.validateBonusNumber(input.toInt(), winningNumber)
            }
        }

        @ParameterizedTest
        @CsvSource("0", "46")
        fun `값이 1에서 45 범위를 벗어나면 오류가 발생한다`(input: String) {
            assertThrows<IllegalArgumentException> {
                InputValidator.validateBonusNumber(input.toInt(), winningNumber)
            }
        }

        @Test
        fun `값이 null(문자, 공백, 소수 등)이면 오류가 발생한다`() {
            assertThrows<IllegalArgumentException> {
                InputValidator.validateBonusNumber(null, winningNumber)
            }
        }
    }
}