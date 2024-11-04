package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개이고 모두 유효한 범위 내에 있을 경우 아무 일도 일어나지 않음`() {
        // act, assert
        assertDoesNotThrow { Lotto(listOf(1, 2, 3, 4, 5, 6)) }
    }

    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        // act, assert
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호의 개수가 6개 미만일 경우 예외 발생`() {
        // act, assert
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        // act, assert
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `유효한 로또 번호 범위 외의 숫자가 존재할 경우 예외 발생`() {
        // act, assert
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `toString은 항상 오름차순의 로또 번호 문자열을 반환`() {
        // arrange
        val lotto = Lotto(listOf(6, 5, 4, 3, 2, 1))

        // act
        val result = lotto.toString()

        // assert
        val expectedResult = "[1, 2, 3, 4, 5, 6]"
        assertThat(result).isEqualTo(expectedResult)
    }

    @ParameterizedTest
    @MethodSource(value = ["provideParametersForCalculateWinPlace"])
    fun `로또 번호와 당첨 번호, 보너스 번호가 주어질 경우 알맞은 등수를 반환`(
        winningNumbers: List<Int>,
        bonusWinningNumber: Int,
        expectedResult: LottoWinPlace?,
    ) {
        // arrange
        val lotto = Lotto(listOf(6, 5, 4, 3, 2, 1))

        // act
        val lottoWinPlace = lotto.calculateWinPlace(winningNumbers, bonusWinningNumber)

        // assert
        assertThat(lottoWinPlace).isEqualTo(expectedResult)
    }

    companion object {
        @JvmStatic
        fun provideParametersForCalculateWinPlace(): Stream<Arguments> = Stream.of(
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), 7, LottoWinPlace.FIRST_PLACE),
            Arguments.of(listOf(1, 2, 3, 4, 5, 45), 6, LottoWinPlace.SECOND_PLACE),
            Arguments.of(listOf(1, 2, 3, 4, 5, 45), 44, LottoWinPlace.THIRD_PLACE),
            Arguments.of(listOf(1, 2, 3, 4, 44, 45), 7, LottoWinPlace.FOURTH_PLACE),
            Arguments.of(listOf(1, 2, 3, 43, 44, 34), 7, LottoWinPlace.FIFTH_PLACE),
            Arguments.of(listOf(1, 2, 42, 43, 44, 45), 7, null),
        )
    }
}
