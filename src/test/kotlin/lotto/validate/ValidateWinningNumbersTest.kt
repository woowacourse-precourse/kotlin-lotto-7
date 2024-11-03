package lotto.validate

import lotto.utils.Constants
import lotto.utils.Validator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class ValidateWinningNumbersTest {

    @ParameterizedTest
    @MethodSource("provideNotNumberWinningNumbers")
    fun `당첨_번호에_숫자가_아닌_값이_포함되어_있으면_예외를_던진다`(winningNumbers: List<String>) {
        Assertions.assertThatThrownBy { Validator.validateWinningNumbers(winningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Constants.ERROR_WINNING_NUMBERS_NOT_NUMBER)
    }

    @ParameterizedTest
    @MethodSource("provideIncorrectSizeWinningNumbers")
    fun `당첨_번호의_개수가_6개가_아니면_예외를_던진다`(winningNumbers: List<String>) {
        Assertions.assertThatThrownBy { Validator.validateWinningNumbers(winningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Constants.ERROR_WINNING_NUMBERS_INCORRECT_SIZE)
    }

    @ParameterizedTest
    @MethodSource("provideOutOfRangeWinningNumbers")
    fun `당첨_번호에_1부터_45_범위를_벗어나는_숫자가_있으면_예외를_던진다`(winningNumbers: List<String>) {
        Assertions.assertThatThrownBy { Validator.validateWinningNumbers(winningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Constants.ERROR_WINNING_NUMBERS_OUT_OF_RANGE)
    }

    @ParameterizedTest
    @MethodSource("provideDuplicateWinningNumbers")
    fun `당첨_번호에_중복된_숫자가_있으면_예외를_던진다`(winningNumbers: List<String>) {
        Assertions.assertThatThrownBy { Validator.validateWinningNumbers(winningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Constants.ERROR_WINNING_NUMBERS_DUPLICATE)
    }

    @ParameterizedTest
    @MethodSource("provideValidWinningNumbers")
    fun `당첨_번호가_유효하면_예외를_던지지_않는다`(winningNumbers: List<String>) {
        assertDoesNotThrow { Validator.validateWinningNumbers(winningNumbers) }
    }

    companion object {
        @JvmStatic
        fun provideNotNumberWinningNumbers(): Stream<List<String>> {
            return Stream.of(
                listOf("1", "a", "3", "4", "5", "6"),
                listOf("ㄱ", "2", "3", "4", "5", "6"),
                listOf("1", "2", "3", "4", "5", "@"),
                listOf("1", "2", "3", "4", "5", "가")
            )
        }

        @JvmStatic
        fun provideIncorrectSizeWinningNumbers(): Stream<List<String>> {
            return Stream.of(
                listOf("1", "2", "3", "4", "5"),
                listOf("1", "2", "3", "4", "5", "6", "7")
            )
        }

        @JvmStatic
        fun provideOutOfRangeWinningNumbers(): Stream<List<String>> {
            return Stream.of(
                listOf("-1", "2", "3", "4", "5", "6"),
                listOf("0", "2", "3", "4", "5", "6"),
                listOf("46", "2", "3", "4", "5", "6")
            )
        }

        @JvmStatic
        fun provideDuplicateWinningNumbers(): Stream<List<String>> {
            return Stream.of(
                listOf("2", "2", "3", "4", "5", "6"),
                listOf("5", "2", "3", "4", "5", "6"),
                listOf("45", "45", "3", "4", "5", "6")
            )
        }

        @JvmStatic
        fun provideValidWinningNumbers(): Stream<List<String>> {
            return Stream.of(
                listOf("1", "2", "3", "4", "5", "6"),
                listOf("10", "2", "3", "4", "5", "6"),
                listOf("45", "2", "3", "4", "5", "6")
            )
        }
    }
}