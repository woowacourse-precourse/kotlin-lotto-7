package lotto

import app.DependencyInjector
import domain.enums.Rank
import domain.lotto.Lotto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.TreeSet
import java.util.stream.Stream

class LottoTest {
    private lateinit var dependencyInjector: DependencyInjector

    @BeforeEach
    fun setUp() {
        dependencyInjector = DependencyInjector()
    }

    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 테스트가 통과하도록 프로덕션 코드 구현
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호 반환 테스트`() {
        val lottoFactory = dependencyInjector.injectLottoDataSource()
        val lotto = lottoFactory()
        repeat(100000) {
            assertEquals(lotto.size, 6)
            assertTrue(lotto.minOrNull() in 1..45)
            assertTrue(lotto.maxOrNull() in 1..45)
            assertTrue(lotto.size == lotto.distinct().size)
        }
    }

    @ParameterizedTest
    @MethodSource("provideLottoNumbers")
    fun `당첨 등수 반환 테스트`(values: List<Int>, bonusNumber: Int, expect: Rank) {
        val toTreeSet = TreeSet(values)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(expect, lotto.getMatches(toTreeSet, bonusNumber))
    }

    companion object {
        @JvmStatic
        fun provideLottoNumbers(): Stream<Arguments> = Stream.of(
            // 1등
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), 1, Rank.FIRST),
            // 2등
            Arguments.of(listOf(1, 2, 3, 4, 5, 7), 2, Rank.SECOND),
            // 3등
            Arguments.of(listOf(1, 2, 3, 4, 5, 7), 8, Rank.THIRD),
            // 4등
            Arguments.of(listOf(1, 2, 3, 4, 8, 9), 10, Rank.FOURTH),
            // 5등
            Arguments.of(listOf(1, 2, 3, 7, 9, 10), 11, Rank.FIFTH),
            // 당첨 없음
            Arguments.of(listOf(1, 2, 7, 8, 9, 10), 11, Rank.NONE)
        )
    }
}
