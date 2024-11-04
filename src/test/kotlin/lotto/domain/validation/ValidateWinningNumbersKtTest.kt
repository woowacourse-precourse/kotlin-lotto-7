package lotto.domain.validation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class ValidateWinningNumbersKtTest {
    @Test
    fun `당첨 번호가 6개이며 모두 유효한 범위 내에 있으면 아무 일도 일어나지 않음`() {
        // act, assert
        assertDoesNotThrow { validateWinningNumbers(listOf(1, 2, 3, 4, 5, 6)) }
    }

    @Test
    fun `당첨 번호에 중복이 있을 경우 예외 발생`() {
        // act, assert
        assertThrows<IllegalArgumentException> { validateWinningNumbers(listOf(1, 2, 3, 4, 5, 5)) }
    }

    @ParameterizedTest
    @MethodSource(value = ["getInvalidLengthWinningNumbers"])
    fun `당첨 번호가 6개가 아닌 경우 예외 발생`(winningNumbers: List<Int>) {
        // act, assert
        assertThrows<IllegalArgumentException> { validateWinningNumbers(winningNumbers) }
    }

    @ParameterizedTest
    @MethodSource(value = ["getWinningNumbersIncludingOutOfRangeValue"])
    fun `당첨 번호 중 유효한 범위 외의 숫자가 존재할 경우 예외 발생`(winningNumbers: List<Int>) {
        // act, assert
        assertThrows<IllegalArgumentException> { validateWinningNumbers(winningNumbers) }
    }

    companion object {
        @JvmStatic
        fun getInvalidLengthWinningNumbers(): Stream<List<Int>> = Stream.of(
            listOf(1, 2, 3, 4, 5),
            listOf(1, 2, 3, 4, 5, 6, 7)
        )

        @JvmStatic
        fun getWinningNumbersIncludingOutOfRangeValue(): Stream<List<Int>> = Stream.of(
            listOf(1, 2, 3, 4, 5, 0),
            listOf(1, 2, 3, 4, 5, 46)
        )
    }
}
