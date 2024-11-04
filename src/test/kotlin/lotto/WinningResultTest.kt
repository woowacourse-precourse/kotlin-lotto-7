package lotto

import lotto.data.Rank
import lotto.data.WinningResult
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@DisplayName("당첨 내역 테스트 케이스")
class WinningResultTest {
    @DisplayName("당첨 번호, 보너스 번호, 로또 번호를 가지고 등수 판별")
    @ParameterizedTest
    @MethodSource("rankSource")
    fun rankIsRight(
        winningNumbers: List<Int>,
        bonusNumber: Int,
        lottoNumbers: List<List<Int>>,
        expectedResult: Map<Rank, Int>
    ) {
        assertEquals(WinningResult(lottoNumbers, winningNumbers, bonusNumber).details, expectedResult)
    }

    @DisplayName("1~5등 까지 당첨 되지 않았을 경우")
    @ParameterizedTest
    @MethodSource("rankNotMatchSource")
    fun rankNotMatch(
        winningNumbers: List<Int>,
        bonusNumber: Int,
        lottoNumbers: List<List<Int>>,
        expectedResult: Map<Rank, Int>
    ) {
        assertEquals(WinningResult(lottoNumbers, winningNumbers, bonusNumber).details, expectedResult)
    }

    @DisplayName("로또 수익률 계산이 틀릴 경우")
    @ParameterizedTest
    @MethodSource("profitRateSource")
    fun profitRateIsFailed(
        winningNumbers: List<Int>,
        bonusNumber: Int,
        lottoNumbers: List<List<Int>>,
        expectedResult: String
    ) {
        val winningResult = WinningResult(lottoNumbers, winningNumbers, bonusNumber)
        val profitRate = String.format("%,.1f%%", winningResult.profitRate)
        assertEquals(profitRate, expectedResult)
    }

    companion object {
        @JvmStatic
        fun rankSource(): Stream<Arguments> = Stream.of(
            arguments(
                listOf(1, 2, 3, 4, 5, 6), 7,
                listOf(
                    // 1등
                    listOf(1, 2, 3, 4, 5, 6),
                    // 2등
                    listOf(1, 2, 3, 4, 5, 7),
                    listOf(1, 2, 3, 4, 6, 7),
                    listOf(1, 2, 3, 5, 6, 7),
                    listOf(1, 2, 4, 5, 6, 7),
                    listOf(1, 3, 4, 5, 6, 7),
                    listOf(2, 3, 4, 5, 6, 7),
                    // 3등
                    listOf(1, 2, 3, 4, 5, 8),
                    listOf(1, 2, 3, 4, 6, 8),
                    listOf(1, 2, 3, 5, 6, 8),
                    listOf(1, 2, 4, 5, 6, 8),
                    listOf(1, 3, 4, 5, 6, 8),
                    listOf(2, 3, 4, 5, 6, 8),
                    // 4등
                    listOf(1, 2, 3, 4, 8, 9),
                    listOf(2, 3, 4, 5, 8, 9),
                    listOf(3, 4, 5, 6, 8, 9),
                    listOf(1, 2, 4, 5, 8, 9),
                    listOf(1, 2, 5, 6, 8, 9),
                    listOf(2, 4, 5, 6, 8, 9),
                    // 5등
                    listOf(1, 2, 3, 7, 8, 9),
                    listOf(4, 5, 6, 7, 8, 9),
                    listOf(1, 5, 6, 7, 8, 9),
                    listOf(2, 4, 6, 8, 9, 10),
                    listOf(3, 5, 6, 7, 10, 11),
                    listOf(3, 5, 6, 21, 22, 23),
                    // miss
                    listOf(11, 12, 13, 14, 15, 16),
                    listOf(21, 22, 23, 24, 25, 26),
                    listOf(15, 16, 17, 18, 19, 20),
                    listOf(30, 31, 35, 40, 41, 44),
                    listOf(9, 15, 16, 25, 42, 43),
                    listOf(17, 18, 23, 24, 36, 45)
                ),
                mapOf(
                    Rank.FIRST to 1,
                    Rank.SECOND to 6,
                    Rank.THIRD to 6,
                    Rank.FOURTH to 6,
                    Rank.FIFTH to 6,
                )
            )
        )

        @JvmStatic
        fun rankNotMatchSource(): Stream<Arguments> = Stream.of(
            arguments(
                listOf(1, 2, 3, 4, 5, 6), 7,
                listOf(
                    listOf(10, 11, 12, 13, 14, 15)
                ),
                mapOf(
                    Rank.FIRST to 0,
                    Rank.SECOND to 0,
                    Rank.THIRD to 0,
                    Rank.FOURTH to 0,
                    Rank.FIFTH to 0,
                )
            )
        )

        @JvmStatic
        fun profitRateSource(): Stream<Arguments> = Stream.of(
            arguments(
                listOf(1, 2, 3, 4, 5, 6), 7,
                listOf(
                    listOf(1, 2, 3, 4, 5, 6),
                    listOf(1, 2, 3, 4, 5, 7),
                    listOf(1, 2, 3, 8, 9, 10)
                ),
                String.format("%,.1f%%", 67_666_833.3333)
            ),
            arguments(
                listOf(1, 2, 3, 4, 5, 6), 7,
                listOf(
                    listOf(1, 2, 3, 7, 8, 9),
                    listOf(1, 2, 3, 4, 7, 9),
                    listOf(1, 2, 3, 4, 5, 7),
                    listOf(11, 12, 13, 14, 15, 16)
                ),
                String.format("%,.1f%%", 751375.0)
            ),
            arguments(
                listOf(1, 2, 3, 4, 5, 6), 7,
                listOf(
                    listOf(11, 12, 13, 14, 15, 16),
                    listOf(12, 22, 32, 42, 43, 44),
                    listOf(21, 22, 23, 24, 25, 26)
                ),
                String.format("%,.1f%%", 0.00000000)
            ),
            arguments(
                listOf(1, 2, 3, 4, 5, 6), 7,
                listOf(
                    listOf(8, 21, 23, 41, 42, 43),
                    listOf(3, 5, 11, 16, 32, 38),
                    listOf(7, 11, 16, 35, 36, 44),
                    listOf(1, 8, 11, 31, 41, 42),
                    listOf(13, 14, 16, 38, 42, 45),
                    listOf(7, 11, 30, 40, 42, 43),
                    listOf(2, 13, 22, 32, 38, 45),
                    listOf(1, 3, 5, 14, 22, 45)
                ),
                String.format("%,.1f%%", 62.5)
            )
        )
    }
}