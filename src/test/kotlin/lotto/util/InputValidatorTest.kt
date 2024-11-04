package lotto.util

import lotto.util.ExceptionConstants.ERROR_MESSAGE_INPUT_EMPTY
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class InputValidatorTest {

    @Test
    fun `입력이 빈 문자열일 때 예외가 발생해야 한다`() {
        assertThatThrownBy { InputValidator.validateInputIsNotEmpty("") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ERROR_MESSAGE_INPUT_EMPTY)
    }

    @Test
    fun `입력이 공백 문자열일 때 예외가 발생해야 한다`() {
        assertThatThrownBy { InputValidator.validateInputIsNotEmpty("  ") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ERROR_MESSAGE_INPUT_EMPTY)
    }

    @Test
    fun `입력이 유효한 문자열일 때 예외가 발생하지 않아야 한다`() {
        InputValidator.validateInputIsNotEmpty("유효한 입력")
    }
}
