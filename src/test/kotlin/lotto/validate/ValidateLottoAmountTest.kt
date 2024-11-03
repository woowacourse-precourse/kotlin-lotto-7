package lotto.validate

import lotto.utils.Constants
import lotto.utils.Validator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidateLottoAmountTest {

    @ParameterizedTest
    @ValueSource(strings = ["abc", "가나다", "*#!", "1a2b3c"])
    fun `로또_구입_금액이_숫자가_아니면_예외를_던진다`(value: String) {
        Assertions.assertThatThrownBy { Validator.validateLottoAmount(value) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Constants.ERROR_AMOUNT_NOT_NUMBER)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "0", "999"])
    fun `로또_구입_금액이_1000원_미만이면_예외를_던진다`(value: String) {
        Assertions.assertThatThrownBy { Validator.validateLottoAmount(value) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Constants.ERROR_AMOUNT_UNDER_1000)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1234", "2221", "10001"])
    fun `로또_구입_금액이_1000으로_나누어_떨어지지_않으면_예외를_던진다`(value: String) {
        Assertions.assertThatThrownBy { Validator.validateLottoAmount(value) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Constants.ERROR_AMOUNT_NOT_DIVIDE_BY_1000)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1000", "5000", "12000"])
    fun `로또_구입_금액이_유효하면_예외를_던지지_않는다`(value: String) {
        assertDoesNotThrow { Validator.validateLottoAmount(value) }
    }
}