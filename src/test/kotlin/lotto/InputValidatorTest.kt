package lotto

import lotto.util.InputValidator
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidatorTest {
    @Test
    @DisplayName("입력값이 존재하지 않는 경우 예외가 발생한다.")
    fun input_null_test() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateInput(" ")
        }
    }

    @Test
    @DisplayName("입력값에 숫자가 아닌 값이 포함된 경우 예외가 발생한다.")
    fun input_isNotDigit_test() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateInput("1a")
        }
    }

    @Test
    @DisplayName("입력값이 자연수가 아닌 경우 예외가 발생한다.")
    fun input_natural_test() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateInput("-1")
        }
    }
}
