package lotto.domain

import lotto.util.Constants
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoResultTest {

    @Test
    fun `로또 결과에서 총 당첨 금액을 정확히 계산한다`() {
        val rankCounts = mapOf(
            Rank.FIRST to 1,
            Rank.SECOND to 0,
            Rank.THIRD to 2,
            Rank.FOURTH to 3,
            Rank.FIFTH to 5,
            Rank.NONE to 0
        )
        val lottoResult = LottoResult(rankCounts)
        val expectedTotalPrize = Rank.FIRST.prizeMoney * 1 +
                Rank.THIRD.prizeMoney * 2 +
                Rank.FOURTH.prizeMoney * 3 +
                Rank.FIFTH.prizeMoney * 5
        assertEquals(expectedTotalPrize, lottoResult.calculateTotalPrize())
    }

    @Test
    fun `로또 결과에서 수익률을 정확히 계산한다`() {
        val rankCounts = mapOf(
            Rank.THIRD to 1
        )
        val lottoResult = LottoResult(rankCounts)
        val purchaseAmount = 5_000
        val expectedYield = (Rank.THIRD.prizeMoney.toDouble() / purchaseAmount) * 100
        assertEquals(expectedYield, lottoResult.calculateYield(purchaseAmount))
    }
}
