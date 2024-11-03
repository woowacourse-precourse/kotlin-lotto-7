package lotto.util

import lotto.util.validator.winningnumbers.WinningNumbersErrorType
import lotto.util.validator.winningnumbers.WinningNumbersValidator
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WinningNumbersValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = [""])
    @DisplayName("당첨 번호 - 빈 문자")
    fun `보너스 번호에 빈 문자열이 들어오면 예외가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            WinningNumbersValidator(input).validateLuckyNumbers()
        }
        assert(exception.message == WinningNumbersErrorType.EMPTY_INPUT.errorMessage)
    }

    @ParameterizedTest
    @ValueSource(strings = ["3.524,55.61,5.2,1.5,2.4,22", "1,2, 3, 4, 5,4.5"])
    @DisplayName("당첨 번호 - 소수")
    fun `당첨 번호에 소수가 들어오면 예외가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            WinningNumbersValidator(input).validateLuckyNumbers()
        }
        assert(exception.message == WinningNumbersErrorType.NOT_DECIMAL.errorMessage)
    }

    @ParameterizedTest
    @ValueSource(strings = ["3.52455.615.5.422", "1;2;3;4/5(45"])
    @DisplayName("당첨 번호 - 구분자(,)가 없는 상황")
    fun `당첨 번호에 구분자(,)가 안 들어오면 예외가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            WinningNumbersValidator(input).validateLuckyNumbers()
        }
        assert(exception.message == WinningNumbersErrorType.N0_COMMA.errorMessage)
    }

    @ParameterizedTest
    @ValueSource(strings = ["가나다라마바,사,타", "!, 7", "1ㄱ,2ㅈ,3ㅇ", ";,", ",,"])
    @DisplayName("당첨 번호 - 정수가 아닌 것")
    fun `당첨 번호에 정수가 아닌 것이 들어오면 예외가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            WinningNumbersValidator(input).validateLuckyNumbers()
        }
        assert(exception.message == WinningNumbersErrorType.NOT_INTEGER.errorMessage)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1, 1,2,3,4,5", "0, 1,2,3,4,5", "46, 1,2,3,4,5"])
    @DisplayName("당첨 번호 - 1 ~ 45")
    fun `당첨 번호에 1 ~ 45사이가 아닌 것이 들어오면 예외가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            WinningNumbersValidator(input).validateLuckyNumbers()
        }
        assert(exception.message == WinningNumbersErrorType.LUCKY_NUMBERS_RANGE.errorMessage)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1, 1, 3, 4, 5, 6"])
    @DisplayName("당첨 번호 - 중복된 당첨 번호")
    fun `당첨 번호에 중복된 번호가 들어오면 예외가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            WinningNumbersValidator(input).validateLuckyNumbers()
        }
        assert(exception.message == WinningNumbersErrorType.NO_DUPLICATE_LUCKY_NUMBERS.errorMessage)  }

    @ParameterizedTest
    @ValueSource(strings = ["1, 3, 4, 5, 6"])
    @DisplayName("당첨 번호 - 6개")
    fun `당첨 번호에 번호 6개가 안 들어오면 예외가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            WinningNumbersValidator(input).validateLuckyNumbers()
        }
        assert(exception.message == WinningNumbersErrorType.LUCKY_NUMBERS_6.errorMessage)  }
}