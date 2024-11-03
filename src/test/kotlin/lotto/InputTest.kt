package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

import lotto.util.InputParser.parseNumericInput
import lotto.util.InputParser.parseWinningNumbers
import lotto.util.InputValidator.validateMoneyIsNotNegative
import lotto.util.InputValidator.validateMoneyIsEnough
import lotto.util.InputValidator.validateMoneyIsDivisible

class InputTest {
    @ParameterizedTest
    @ValueSource(strings = ["", "abc"])
    fun `숫자로 변환될 수 없는 문자열이 입력된 경우 예외가 발생한다`(input: String) {
        assertThrows<IllegalArgumentException> { parseNumericInput(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,a", ",,,,,", "1,2,,4,5,6", ",1,2,3,4,"])
    fun `당첨 번호 중 숫자로 변환될 수 없는 문자열이 있을 경우 예외가 발생한다`(input: String) {
        assertThrows<IllegalArgumentException> { parseWinningNumbers(input) }
    }

    @Test
    fun `구매 금액이 음수일 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> { validateMoneyIsNotNegative(-1000) }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 100])
    fun `구매 금액으로 로또를 하나도 구매할 수 없을 경우 발생한다`(input: Int) {
        assertThrows<IllegalArgumentException> { validateMoneyIsEnough(input) }
    }

    @Test
    fun `구매 금액이 로또의 가격으로 나누어 떨어지지 않을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> { validateMoneyIsDivisible(1001) }
    }
}
