package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WinningResultTest {

    private val purchasedPrice = "8000"
    private val expectedRateOfReturn = 62.5f
    private val lottos = listOf(Lotto(listOf(1, 2, 3, 11, 22, 33)), Lotto(listOf(11, 22, 33, 44, 35, 12)))
    private val inputNumbers = InputNumbers("1,2,3,4,5,6", "7")
    private val winningResult = WinningResult(lottos, inputNumbers)

    @Test
    fun `수익률 계산 테스트`() {
        winningResult.getPrizeRankMessage()
        val result = winningResult.getRateOfReturn(purchasedPrice)

        assertEquals(expectedRateOfReturn, result)

    }

    @Test
    fun `당첨결과 메시지 테스트`() {
        val result = winningResult.getPrizeRankMessage()
        val expectedMessages = listOf(
            "3개 일치 (5,000원) - 1",
            "4개 일치 (50,000원) - 0",
            "5개 일치 (1,500,000원) - 0",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0",
            "6개 일치 (2,000,000,000원) - 0"
        )

        assertEquals(expectedMessages, result)
    }
}
