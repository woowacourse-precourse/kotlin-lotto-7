package lotto.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoResultCalculatorTest {

    @Test
    fun `로또 결과를 계산한다`() {
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lotto2 = Lotto(listOf(10, 11, 12, 13, 14, 15))
        val lottoBundle = listOf(lotto1, lotto2)
        val winningLotto = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val bonusNumber = 10

        val lottoResultCalculator = LottoResultCalculator(winningLotto, bonusNumber)
        val result = lottoResultCalculator.countMatchingNumber(lottoBundle)

        assertEquals(0, result[LottoWinning.FIRST])
        assertEquals(0, result[LottoWinning.SECOND])
        assertEquals(0, result[LottoWinning.THIRD])
        assertEquals(0, result[LottoWinning.FOURTH])
        assertEquals(1, result[LottoWinning.FIFTH])
        assertEquals(1, result[LottoWinning.NONE])
    }

    @Test
    fun `2등과 3등을 올바르게 구하는지 확인한다`() {
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lotto2 = Lotto(listOf(1, 2, 3, 4, 5, 15))
        val lottoBundle = listOf(lotto1, lotto2)
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 9))
        val bonusNumber = 6

        val lottoResultCalculator = LottoResultCalculator(winningLotto, bonusNumber)
        val result = lottoResultCalculator.countMatchingNumber(lottoBundle)

        assertEquals(0, result[LottoWinning.FIRST])
        assertEquals(1, result[LottoWinning.SECOND])
        assertEquals(1, result[LottoWinning.THIRD])
        assertEquals(0, result[LottoWinning.FOURTH])
        assertEquals(0, result[LottoWinning.FIFTH])
        assertEquals(0, result[LottoWinning.NONE])
    }

    @Test
    fun `로또 당첨금을 올바르게 계산하는지 확인한다`() {
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lotto2 = Lotto(listOf(1, 2, 3, 7, 8, 11))
        val lottoBundle = listOf(lotto1, lotto2)
        val winningLotto = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val bonusNumber = 10

        val lottoResultCalculator = LottoResultCalculator(winningLotto, bonusNumber)
        lottoResultCalculator.countMatchingNumber(lottoBundle)
        val totalReward = lottoResultCalculator.calculateTotalReward()
        assertEquals(1_505_000, totalReward)

    }

    @Test
    fun `로또 수익률을 올바르게 계산하는지 확인한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lottoBundle = listOf(lotto)
        val lottoCount = 8
        val winningLotto = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val bonusNumber = 10

        val lottoResultCalculator = LottoResultCalculator(winningLotto, bonusNumber)
        lottoResultCalculator.countMatchingNumber(lottoBundle)
        val totalReward = lottoResultCalculator.calculateTotalReward()
        val profitRate = lottoResultCalculator.calculateProfitRate(lottoCount, totalReward)

        assertEquals(62.5, profitRate)
    }
}