package lotto.util

import lotto.domain.model.Lotto
import lotto.util.validator.bonusnumber.BonusNumberErrorType
import lotto.util.validator.bonusnumber.BonusNumberValidator
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BonusNumberValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = [""])
    @DisplayName("보너스 번호 - 빈 문자")
    fun `보너스 번호에 빈 문자열이 들어오면 예외가 발생한다`(input: String) {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val exception = assertThrows<IllegalArgumentException> {
            BonusNumberValidator(lotto = lotto, bonusNumber = input).validateBonusNumber()
        }
        assert(exception.message == BonusNumberErrorType.EMPTY_INPUT.errorMessage)
    }

    @ParameterizedTest
    @ValueSource(strings = ["3.524", "55.61"])
    @DisplayName("보너스 번호 - 소수")
    fun `보너스 번호에 소수가 들어오면 예외가 발생한다`(input: String) {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val exception = assertThrows<IllegalArgumentException> {
            BonusNumberValidator(lotto = lotto, bonusNumber = input).validateBonusNumber()
        }
        assert(exception.message == BonusNumberErrorType.NOT_DECIMAL.errorMessage)
    }

    @ParameterizedTest
    @ValueSource(strings = ["829034589023485902348-5-0923458-9023485609-243-5809-234", "!", "가나다라마", "1,2,3", "2 3"])
    @DisplayName("보너스 번호 - 정수가 아닌 것")
    fun `보너스 번호에 정수가 아닌 것이 들어오면 예외가 발생한다`(input: String) {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val exception = assertThrows<IllegalArgumentException> {
            BonusNumberValidator(lotto = lotto, bonusNumber = input).validateBonusNumber()
        }
        assert(exception.message == BonusNumberErrorType.NOT_INTEGER.errorMessage)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "0", "46"])
    @DisplayName("보너스 번호 - 1 ~ 45")
    fun `보너스 번호에 1 ~ 45사이가 아닌 것이 들어오면 예외가 발생한다`(input: String) {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val exception = assertThrows<IllegalArgumentException> {
            BonusNumberValidator(lotto = lotto, bonusNumber = input).validateBonusNumber()
        }
        assert(exception.message == BonusNumberErrorType.BONUS_NUMBER_RANGE.errorMessage)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3", "4", "5", "6"])
    @DisplayName("보너스 번호 - 당첨 번호와 중복된 보너스 번호")
    fun `보너스 번호에 당첨 번호와 중복된 보너스 번호가 들어오면 예외가 발생한다`(input: String) {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val exception = assertThrows<IllegalArgumentException> {
            BonusNumberValidator(lotto = lotto, bonusNumber = input).validateBonusNumber()
        }
        assert(exception.message == BonusNumberErrorType.NO_DUPLICATE_LUCKY_NUMBERS.errorMessage)
    }
}