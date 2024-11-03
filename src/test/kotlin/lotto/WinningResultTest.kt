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
    }
}