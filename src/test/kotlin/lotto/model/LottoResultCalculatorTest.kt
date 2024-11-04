package lotto.model

import lotto.dto.WinningTicket
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class LottoResultCalculatorTest {

    @Test
    fun `로또 결과를 계산한다`() {
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lotto2 = Lotto(listOf(10, 11, 12, 13, 14, 15))
        val lottoBundle = listOf(lotto1, lotto2)
        val winningLotto = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val bonusNumber = 10

        val winningTicket = WinningTicket(winningLotto, bonusNumber)

        val lottoResultCalculator = LottoResultCalculator(winningTicket)
        val result = lottoResultCalculator.countMatchingNumber(lottoBundle)


        assertThat(result[LottoWinning.FIRST]).isEqualTo(0)
        assertThat(result[LottoWinning.SECOND]).isEqualTo(0)
        assertThat(result[LottoWinning.THIRD]).isEqualTo(0)
        assertThat(result[LottoWinning.FOURTH]).isEqualTo(0)
        assertThat(result[LottoWinning.FIFTH]).isEqualTo(1)
        assertThat(result[LottoWinning.NONE]).isEqualTo(1)
    }

    @Test
    fun `2등과 3등을 올바르게 구하는지 확인한다`() {
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lotto2 = Lotto(listOf(1, 2, 3, 4, 5, 15))
        val lottoBundle = listOf(lotto1, lotto2)
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 9))
        val bonusNumber = 6
        val winningTicket = WinningTicket(winningLotto, bonusNumber)

        val lottoResultCalculator = LottoResultCalculator(winningTicket)
        val result = lottoResultCalculator.countMatchingNumber(lottoBundle)

        assertThat(result[LottoWinning.FIRST]).isEqualTo(0)
        assertThat(result[LottoWinning.SECOND]).isEqualTo(1)
        assertThat(result[LottoWinning.THIRD]).isEqualTo(1)
        assertThat(result[LottoWinning.FOURTH]).isEqualTo(0)
        assertThat(result[LottoWinning.FIFTH]).isEqualTo(0)
        assertThat(result[LottoWinning.NONE]).isEqualTo(0)
    }

    @Test
    fun `로또 당첨금을 올바르게 계산하는지 확인한다`() {
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lotto2 = Lotto(listOf(1, 2, 3, 7, 8, 11))
        val lottoBundle = listOf(lotto1, lotto2)
        val winningLotto = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val bonusNumber = 10
        val winningTicket = WinningTicket(winningLotto, bonusNumber)

        val lottoResultCalculator = LottoResultCalculator(winningTicket)
        lottoResultCalculator.countMatchingNumber(lottoBundle)
        val totalReward = lottoResultCalculator.calculateTotalReward()

        assertThat(totalReward).isEqualTo(1_505_000)

    }

    @Test
    fun `로또 수익률을 올바르게 계산하는지 확인한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lottoBundle = listOf(lotto)
        val lottoCount = 8
        val winningLotto = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val bonusNumber = 10
        val winningTicket = WinningTicket(winningLotto, bonusNumber)

        val lottoResultCalculator = LottoResultCalculator(winningTicket)
        lottoResultCalculator.countMatchingNumber(lottoBundle)
        val totalReward = lottoResultCalculator.calculateTotalReward()
        val profitRate = lottoResultCalculator.calculateProfitRate(lottoCount, totalReward)

        assertThat(profitRate).isEqualTo(62.5)
    }
}