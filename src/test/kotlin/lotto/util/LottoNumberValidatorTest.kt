package lotto.util

import lotto.util.constant.ErrorMessages
import lotto.util.validator.LottoNumberValidator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberValidatorTest {

    @DisplayName("입력 문자열 테스트")
    @Nested
    inner class WinningNumberTest {

        @ParameterizedTest
        @ValueSource(strings = ["1/2/3/4/5/6", "1 2 3 4 5 6", "123456"])
        fun `구분자가 쉼표가 아닐 경우 예외가 발생한다`(input: String) {
            val exception = assertThrows<IllegalArgumentException> { LottoNumberValidator.getValidatedWinningNumbers(input) }

            assertThat(exception).hasMessage(ErrorMessages.LOTTO_NUMBER_DELIMITER)
        }

        @ParameterizedTest
        @ValueSource(strings = ["a,b,c,d,e,f", "1 2,3 4,5 6,7 8,9 10,11 12", " , , , , , "])
        fun `로또 번호가 자연수가 아닌 경우 예외가 발생한다`(input: String) {
            val exception = assertThrows<IllegalArgumentException> { LottoNumberValidator.getValidatedWinningNumbers(input) }

            assertThat(exception).hasMessage(ErrorMessages.LOTTO_NUMBER_NUMERIC)
        }
    }

    @DisplayName("로또 번호 테스트")
    @Nested
    inner class LottoNumbersValidator {

        @DisplayName("로또 개수 테스트")
        @Nested
        inner class RangeTest {

            @Test
            fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
                val input = listOf(1, 2, 3, 4, 5, 6, 7)
                val exception = assertThrows<IllegalArgumentException> { LottoNumberValidator.validateLottoNumbers(input) }

                assertThat(exception).hasMessage(ErrorMessages.LOTTO_NUMBER_COUNT)
            }

            @Test
            fun `로또 번호의 개수가 6개보다 적으면 예외가 발생한다`() {
                val input = listOf(1,2,3)
                val exception = assertThrows<IllegalArgumentException> { LottoNumberValidator.validateLottoNumbers(input) }

                assertThat(exception).hasMessage(ErrorMessages.LOTTO_NUMBER_COUNT)
            }
        }

        @ParameterizedTest
        @ValueSource(ints = [0, 46])
        fun `로또 번호가 범위를 넘어가면 예외가 발생한다`(number: Int) {
            val input = listOf(1,2,3,4,5,number)
            val exception = assertThrows<IllegalArgumentException> { LottoNumberValidator.validateLottoNumbers(input) }

            assertThat(exception).hasMessage(ErrorMessages.LOTTO_NUMBER_RANGE)
        }

        @Test
        fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
            val input = listOf(1, 2, 3, 4, 5, 5)
            val exception = assertThrows<IllegalArgumentException> { LottoNumberValidator.validateLottoNumbers(input) }

            assertThat(exception).hasMessage(ErrorMessages.LOTTO_NUMBER_UNIQUE)
        }
    }
}