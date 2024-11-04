package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BonusTest {

    @ParameterizedTest
    @ValueSource(strings = ["a", "ㄱ", ""])
    fun `보너스 숫자가 올바르지 않은 값인 경우 예외를 발생기킨다`(inputNumber: String) {
        // When
        val exception = assertThrows<IllegalArgumentException> {
            Bonus(inputNumber)
        }

        // Then
        assertThat(INPUT_NUMBER_PARSE_ERROR_MESSAGE).isEqualTo(exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "50"])
    fun `보너스 숫자가 지정된 범위를 벗어난 경우 예외를 발생기킨다`(inputNumber: String) {
        // When
        val exception = assertThrows<IllegalArgumentException> {
            Bonus(inputNumber)
        }

        // Then
        assertThat(NUMBER_RANGE_ERROR_MESSAGE).isEqualTo(exception.message)
    }

    @Test
    fun `올바른 숫자가 입력된 경우 올바른 보너스 숫자를 반환한다`() {
        // Given
        val inputNumber = "5"

        // When
        val bonusNumber = Bonus(inputNumber).number

        // Then
        assertThat(bonusNumber).isEqualTo(5)
    }

    companion object {
        private const val START_RANGE = 1
        private const val END_RANGE = 45
        private const val INPUT_NUMBER_PARSE_ERROR_MESSAGE = "보너스 숫자는 숫자를 입력해야 합니다."
        private const val NUMBER_RANGE_ERROR_MESSAGE = "보너스 숫자는 $START_RANGE ~ $END_RANGE 중에서 입력해야 합니다."
    }

}
