package lotto.utils

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidatorTest {
    @Nested
    @DisplayName("입력된 금액의 유효성을 검사한다")
    inner class PriceValidatorTest {
        @ParameterizedTest
        @ValueSource(strings = ["7900", "0", "-1000"])
        fun `유효하지 않은 금액이 입력된 경우 오류가 발생한다`(price: String) {
            assertThrows<IllegalArgumentException> { Validator.getPrice(price) }
        }

        @Test
        fun `숫자로 변환할 수 없는 경우 오류가 발생한다`() {
            assertThrows<IllegalArgumentException> { Validator.getPrice("1000;") }
        }
    }

    @Nested
    @DisplayName("입력된 당첨 번호의 유효성을 검사한다")
    inner class WinningNumberValidatorTest {
        @Test
        fun `당첨 숫자가 총 6개가 아닌 경우 오류가 발생한다`() {
            val winningNumber = "1,2,3,4,5,6,7"
            assertThrows<IllegalArgumentException> { Validator.getWinningNumber(winningNumber) }
        }

        @Test
        fun `당첨 숫자가 중복되면 오류가 발생한다`() {
            val winningNumber = "1,2,3,4,5,5"
            assertThrows<IllegalArgumentException> { Validator.getWinningNumber(winningNumber) }
        }

        @ParameterizedTest
        @ValueSource(strings = ["-1,2,3,4,5,6", "1,2,3,4,5,46"])
        fun `1~45의 범위를 초과하는 숫자가 입력되면 오류가 발생한다`(winningNumber: String) {
            assertThrows<IllegalArgumentException> { Validator.getWinningNumber(winningNumber) }
        }

        @Test
        fun `쉼표로 구분할 수 없는 경우, 숫자로 변환이 불가능한 경우 오류가 발생한다`() {
            val winningNumber = "1.2.3.4.5.6"
            assertThrows<IllegalArgumentException> { Validator.getWinningNumber(winningNumber) }
        }
    }

    @Nested
    @DisplayName("입력된 보너스 번호의 유효성을 검사한다")
    inner class BonusNumberValidatorTest {
        @Test
        fun `숫자로 변환할 수 없는 경우 오류가 발생한다`() {
            val winningNumber = setOf(1, 2, 3, 4, 5, 6)
            val bonusNumber = "1a"
            assertThrows<IllegalArgumentException> { Validator.getBonusNumber(bonusNumber, winningNumber) }
        }

        @Test
        fun `당첨 숫자와 보너스 숫자가 중복되는 경우 오류가 발생한다`() {
            val winningNumber = setOf(1, 2, 3, 4, 5, 6)
            val bonusNumber = "1"
            assertThrows<IllegalArgumentException> { Validator.getBonusNumber(bonusNumber, winningNumber) }
        }

        @ParameterizedTest
        @ValueSource(strings = ["-1", "46"])
        fun `1~45의 범위를 초과하는 숫자가 입력되면 오류가 발생한다`(bonusNumber: String) {
            val winningNumber = setOf(1, 2, 3, 4, 5, 6)
            assertThrows<IllegalArgumentException> { Validator.getBonusNumber(bonusNumber, winningNumber) }
        }
    }
}