package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoTest {

    @DisplayName("로또 번호 검증 테스트")
    @Nested
    inner class LottoNumbersValidator {

        @DisplayName("범위 테스트")
        @Nested
        inner class RangeTest {

            @Test
            fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
                assertThrows<IllegalArgumentException> {
                    Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
                }
            }

            @Test
            fun `로또 번호의 개수가 6개보다 적으면 예외가 발생한다`() {
                assertThrows<IllegalArgumentException> {
                    Lotto(listOf(1,2,3))
                }
            }
        }

        @ParameterizedTest
        @ValueSource(ints = [0, 46])
        fun `로또 번호가 범위를 넘어가면 예외가 발생한다`(number: Int) {
            assertThrows<IllegalArgumentException> {
                Lotto(listOf(1,2,3,4,5,number))
            }
        }

        @Test
        fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
            assertThrows<IllegalArgumentException> {
                Lotto(listOf(1, 2, 3, 4, 5, 5))
            }
        }
    }

    @Test
    fun `로또 번호 리스트는 불변성을 유지한다`() {
        val originalNumbers = listOf(1,2,3,4,5,6)
        val lotto = Lotto(originalNumbers)

        val lottoNumbers = lotto.getLottoNumber()

        val modifiedNumbers = lottoNumbers.toMutableList()
        modifiedNumbers[0] = 45

        assertEquals(originalNumbers, lotto.getLottoNumber())
    }

    @DisplayName("로또 등수 테스트")
    @Nested
    inner class LottoRankTest {
        private val winningNumber = listOf(1, 2, 3, 4, 5, 6)
        private val bonusNumber = 7

        @DisplayName("당첨일 경우")
        @Nested
        inner class InRank {

            @Test
            fun `모든 번호가 일치하는 경우 1등`() {
                val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
                val rank = lotto.getLottoRank(winningNumber, bonusNumber)

                assertEquals(LottoRank.FIRST, rank)
            }

            @Test
            fun `5개 번호 일치 + 보너스 번호 일치하는 경우 2등`() {
                val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
                val rank = lotto.getLottoRank(winningNumber, bonusNumber)
                assertEquals(LottoRank.SECOND, rank)
            }

            @Test
            fun `5개 번호 일치하는 경우 3등`() {
                val lotto = Lotto(listOf(1, 2, 3, 4, 5, 8))
                val rank = lotto.getLottoRank(winningNumber, bonusNumber)
                assertEquals(LottoRank.THIRD, rank)
            }

            @Test
            fun `4개 번호 일치하는 경우 4등`() {
                val lotto = Lotto(listOf(1, 2, 3, 4, 7, 8))
                val rank = lotto.getLottoRank(winningNumber, bonusNumber)
                assertEquals(LottoRank.FOURTH, rank)
            }

            @Test
            fun `3개 번호 일치하는 경우 5등`() {
                val lotto = Lotto(listOf(1, 2, 3, 7, 8, 9))
                val rank = lotto.getLottoRank(winningNumber, bonusNumber)
                assertEquals(LottoRank.FIFTH, rank)
            }
        }

        @DisplayName("꽝인 경우")
        @Nested
        inner class OutOfRankTest {

            @Test
            fun `2개 번호가 일치하는 경우 꽝`() {
                val lotto = Lotto(listOf(1, 2, 7, 8, 9, 10))
                val rank = lotto.getLottoRank(winningNumber, bonusNumber)
                assertEquals(LottoRank.OUT_OF_RANK, rank)
            }

            @Test
            fun `1개 번호 일치하는 경우 꽝`() {
                val lotto = Lotto(listOf(1, 7, 8, 9, 10, 11))
                val rank = lotto.getLottoRank(winningNumber, bonusNumber)
                assertEquals(LottoRank.OUT_OF_RANK, rank)
            }

            @Test
            fun `번호가 하나도 일치하지 않는 경우 꽝`() {
                val lotto = Lotto(listOf(7, 8, 9, 10, 11, 12))
                val rank = lotto.getLottoRank(winningNumber, bonusNumber)
                assertEquals(LottoRank.OUT_OF_RANK, rank)
            }
        }
    }
}
