package lotto.validator

import lotto.exception.ExceptionCode
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = arrayOf("1,2,3,4,5", "1,2,3,4,5,6,7"))
    fun `로또 번호는 쉼표기준으로 나누었을 때 6개가 아니면 예외를 반환한다`(input: String) {
        // given
        val actual = input.toIntList()
        val exceptionMessage = ExceptionCode.INVALID_LOTTO_NUMBER_COUNT.getMessage()

        assertThatRuntimeException().isThrownBy {
            LottoValidator.validate(actual)
        }.withMessage(exceptionMessage)
    }

    @ParameterizedTest
    @ValueSource(strings = arrayOf("1,2,3,4,5,46", "0,2,3,4,5,6"))
    fun `로또 번호는 1 ~ 45 범위를 벗어난 숫자가 포함될 경우 예외를 반환한다`(input: String) {
        // given
        val actual = input.toIntList()
        val exceptionMessage = ExceptionCode.OUT_OF_BOUND_LOTTO_NUMBER.getMessage()

        assertThatRuntimeException().isThrownBy {
            LottoValidator.validate(actual)
        }.withMessage(exceptionMessage)
    }

    @Test
    fun `로또 번호에 중복된 숫자가 존재할 경우 예외를 반환한다`() {
        // given
        val actual = "1,2,3,4,5,1".toIntList()
        val exceptionMessage = ExceptionCode.DUPLICATE_LOTTO_NUMBER.getMessage()

        assertThatRuntimeException().isThrownBy {
            LottoValidator.validate(actual)
        }.withMessage(exceptionMessage)
    }

    @Test
    fun `로또 번호 규정에 적합한 경우 예외를 반환하지 않는다`() {
        // given
        val actual = "3,5,7,9,32,45".toIntList()

        assertThatNoException().isThrownBy {
            LottoValidator.validate(actual)
        }
    }

    private fun String.toIntList(): List<Int> {
        return this.split(LOTTO_DELIMITER).map { it.toInt() }.toList()
    }

    companion object {
        private const val LOTTO_DELIMITER = ","
    }
}

