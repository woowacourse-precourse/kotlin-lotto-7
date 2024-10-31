package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

import lotto.util.InputValidator.validateInputIsNumeric

class InputValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["", "abc"])
    fun `숫자로 변환될 수 없는 문자열이 입력된 경우 예외가 발생한다`(input: String) {
        assertThrows<IllegalArgumentException> { validateInputIsNumeric(input) }
    }
}
