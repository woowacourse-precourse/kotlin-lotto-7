package lotto

import lotto.constant.LottoRank
import lotto.constant.LottoRank.MISS
import lotto.constant.LottoRank.FIFTH
import lotto.constant.LottoRank.FIRST
import lotto.constant.LottoRank.SECOND
import lotto.constant.LottoRank.THIRD
import lotto.constant.LottoRank.FOURTH
import lotto.model.PurchaseMoney
import lotto.model.WinningResult
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class WinningResultTest {

    @ParameterizedTest
    @MethodSource("provideRanksAndTotalPrizeMoney")
    fun `당첨된 로또에 따라 올바른 총 상금을 계산한다`(pair : Pair<List<LottoRank>, Long>) {
        val winningResult = WinningResult.convertToResult(pair.first)

        val totalPrizeMoney = winningResult.getTotalPrizeMoney()

        assertThat(totalPrizeMoney).isEqualTo(pair.second)
    }

   @Test
    fun `10000원으로 당첨된 로또가 5등 1개이면 수익률은 50이다`() {
        val purchaseMoney = PurchaseMoney("10000")
        val ranks: List<LottoRank> = listOf(
            MISS,
            MISS,
            MISS,
            MISS,
            MISS,
            MISS,
            MISS,
            MISS,
            MISS,
            FIFTH
        )
        val winningResult = WinningResult.convertToResult(ranks)

        val yieldRate = winningResult.getYieldRate(purchaseMoney)

        assertThat(yieldRate).isEqualTo(50.0)

    }

    companion object {
        @JvmStatic
        fun provideRanksAndTotalPrizeMoney(): List<Pair<List<LottoRank>, Long>> {
            return listOf(
                Pair(listOf(FIRST), 2_000_000_000),
                Pair(listOf(SECOND), 30_000_000),
                Pair(listOf(THIRD), 1_500_000),
                Pair(listOf(FOURTH), 50_000),
                Pair(listOf(FIFTH), 5_000),
                Pair(listOf(MISS), 0)
            )
        }
    }
}