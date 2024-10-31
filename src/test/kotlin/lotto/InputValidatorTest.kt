package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

import lotto.util.InputValidator.validateInputIsNumeric
import lotto.util.InputValidator.validateMoneyIsNotNegative
import lotto.util.InputValidator.validateMoneyIsDivisible

class InputValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["", "abc"])
    fun `숫자로 변환될 수 없는 문자열이 입력된 경우 예외가 발생한다`(input: String) {
        assertThrows<IllegalArgumentException> { validateInputIsNumeric(input) }
    }

    @Test
    fun `구매 금액이 음수일 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> { validateMoneyIsNotNegative(-1000) }
    }

    @Test
    fun `구매 금액이 로또의 가격으로 나누어 떨어지지 않을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> { validateMoneyIsDivisible(1001) }
    }
}
