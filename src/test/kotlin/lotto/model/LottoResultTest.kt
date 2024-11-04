package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoResultTest {

    @Test
    fun `profitRate 계산이 올바르게 이루어져야 한다`() {
        val prizeCounts = mapOf(
            Prize.FIRST to 1,
            Prize.SECOND to 0,
            Prize.THIRD to 0
        )
        val totalPrize = 2000000
        val purchaseAmount = 1000

        val result = LottoResult(prizeCounts, totalPrize, purchaseAmount)

        assertEquals(199900.0, result.profitRate)
    }
}