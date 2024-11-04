package lotto

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PrizeTest {

    @Test
    fun `당첨금 계산 테스트`() {
        val prize = Prize(second = 1, third = 1, fourth = 1).getPrizeMoney()

        val expectResult = 31550000.0

        Assertions.assertEquals(expectResult, prize)
    }

    @Test
    fun `수익률 계산 테스트`() {
        val prize = Prize(second = 1, third = 1, fourth = 1)
        val payment = "3000"

        val profit = prize.getProfit(payment)

        val expectProfit = (31550000.0 / 3000.0) * 100.0
        val profitFormat = String.format("%.1f", expectProfit)

        Assertions.assertEquals(profitFormat, profit)
    }
}