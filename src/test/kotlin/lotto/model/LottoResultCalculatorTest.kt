package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class LottoResultCalculatorTest {

    @DisplayName("로또 결과 테스트")
    @Nested
    inner class LottoResultsTest {
        private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        private val bonusNumber = 7

        @Test
        fun `로또 결과 1~5등 당첨`() {
            val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6)) // 1
            val lotto2 = Lotto(listOf(1, 2, 3, 4, 5, 7)) // 2
            val lotto3 = Lotto(listOf(1, 2, 3, 4, 5, 8)) // 3
            val lotto4 = Lotto(listOf(1, 2, 3, 4, 7, 8)) // 4
            val lotto5 = Lotto(listOf(1, 2, 3, 7, 8, 9)) // 5
            val lotto6 = Lotto(listOf(2, 3, 4, 5, 6, 8)) // 3
            val lotto7 = Lotto(listOf(3, 4, 5, 8, 9, 10)) // 5
            val lotto8 = Lotto(listOf(2, 4, 5, 9, 7, 8)) // 5

            val lotteries = listOf(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6, lotto7, lotto8)
            val lottoResultCalculator = LottoResultCalculator(lotteries)

            val expected = listOf(
                LottoResult(rank = 1, count = 1),
                LottoResult(rank = 2, count = 1),
                LottoResult(rank = 3, count = 2),
                LottoResult(rank = 4, count = 1),
                LottoResult(rank = 5, count = 3),
            )
            val result = lottoResultCalculator.getLottoResults(winningNumbers, bonusNumber)

            assertEquals(expected, result)
        }

        @Test
        fun `로또 결과 미당첨`() {
            val lotto1 = Lotto(listOf(1, 2, 7, 8, 9, 10))
            val lotto2 = Lotto(listOf(1, 7, 8, 9, 10, 11))
            val lotto3 = Lotto(listOf(7, 8, 9, 10, 11, 12))

            val lotteries = listOf(lotto1, lotto2, lotto3)
            val lottoResultCalculator = LottoResultCalculator(lotteries)

            val expected = listOf(
                LottoResult(rank = 1, count = 0),
                LottoResult(rank = 2, count = 0),
                LottoResult(rank = 3, count = 0),
                LottoResult(rank = 4, count = 0),
                LottoResult(rank = 5, count = 0),
            )
            val result = lottoResultCalculator.getLottoResults(winningNumbers, bonusNumber)

            assertEquals(expected, result)
        }
    }

    @DisplayName("로또 수익률 테스트")
    @Nested
    inner class YieldTest {

        @Test
        fun `로또 수익률을 올바르게 계산한다`() {
            val lottoResults = listOf(
                LottoResult(rank = 5, count = 1)
            )
            val purchaseAmount = 8000

            val lottoResultCalculator = LottoResultCalculator(emptyList())

            val expected = "62.5"
            val result = lottoResultCalculator.getLottoYield(lottoResults, purchaseAmount)

            assertEquals(expected, result)
        }

        @Test
        fun `1,000단위가 넘어갈 때 단위구분을 하는가`() {
            val lottoResults = listOf(
                LottoResult(rank = 1, count = 1),
                LottoResult(rank = 2, count = 1),
                LottoResult(rank = 3, count = 2),
                LottoResult(rank = 4, count = 1),
                LottoResult(rank = 5, count = 3),
            )
            val purchaseAmount = 8000

            val lottoResultCalculator = LottoResultCalculator(emptyList())

            val expected = "25,413,312.5"
            val result = lottoResultCalculator.getLottoYield(lottoResults, purchaseAmount)

            assertEquals(expected, result)
        }
    }
}