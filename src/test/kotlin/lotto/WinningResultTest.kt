package lotto

import lotto.constant.LottoRank
import lotto.constant.LottoRank.MISS
import lotto.constant.LottoRank.FIFTH
import lotto.model.PurchaseMoney
import lotto.model.WinningResult
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class WinningResultTest {
    @Test
    fun `10000원으로 당첨된 로또가 5등 1개이면 수익률은 50이다`() {
        val purchaseMoney = PurchaseMoney("10000")
        val ranks : List<LottoRank> = listOf(
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
}