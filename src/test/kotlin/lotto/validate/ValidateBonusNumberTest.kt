package lotto.validate

import lotto.utils.Constants
import lotto.utils.Validator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidateBonusNumberTest {

    @ParameterizedTest
    @ValueSource(strings = ["a", "ㄱ", "*", "1a2b3c"])
    fun `보너스_번호가_숫자가_아니면_예외를_던진다`(value: String) {
        Assertions.assertThatThrownBy { Validator.validateBonusNumber(value, listOf(1, 2, 3, 4, 5, 6)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Constants.ERROR_BONUS_NUMBER_NOT_NUMBER)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "0", "46"])
    fun `보너스_번호가_1부터_45_범위를_벗어나면_예외를_던진다`(value: String) {
        Assertions.assertThatThrownBy { Validator.validateBonusNumber(value, listOf(1, 2, 3, 4, 5, 6)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Constants.ERROR_BONUS_NUMBER_OUT_OF_RANGE)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3", "4", "5", "6"])
    fun `보너스_번호가_당첨 번호와_중복되면_예외를_던진다`(value: String) {
        Assertions.assertThatThrownBy { Validator.validateBonusNumber(value, listOf(1, 2, 3, 4, 5, 6)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Constants.ERROR_BONUS_NUMBER_DUPLICATE)
    }

    @ParameterizedTest
    @ValueSource(strings = ["7", "14", "25", "33", "39", "45"])
    fun `보너스_번호가_유효하면_예외를_던지지_않는다`(value: String) {
        assertDoesNotThrow { Validator.validateBonusNumber(value, listOf(1, 2, 3, 4, 5, 6)) }
    }
}