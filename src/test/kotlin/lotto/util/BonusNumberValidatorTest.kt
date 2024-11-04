package lotto.util

import lotto.util.constant.ErrorMessages
import lotto.util.validator.BonusNumberValidator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BonusNumberValidatorTest {
    private val winningNumberTest = listOf(1, 2, 3, 4, 5, 6)

    @ParameterizedTest
    @ValueSource(strings = ["a", "#", "", "0.1"])
    fun `입력 값이 정수가 아닌 경우 예외가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> { BonusNumberValidator.getValidatedBonusNumber(input, winningNumberTest) }

        assertThat(exception).hasMessage(ErrorMessages.BONUS_NUMBER_NUMERIC)
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "46"])
    fun `보너스 번호가 범위를 넘어가면 예외가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> { BonusNumberValidator.getValidatedBonusNumber(input, winningNumberTest) }

        assertThat(exception).hasMessage(ErrorMessages.BONUS_NUMBER_RANGE)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3", "4", "5", "6"])
    fun `보너스 번호와 당첨 번호에 중복된 숫자가 있으면 예외가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> { BonusNumberValidator.getValidatedBonusNumber(input, winningNumberTest) }

        assertThat(exception).hasMessage(ErrorMessages.BONUS_NUMBER_UNIQUE)
    }
}