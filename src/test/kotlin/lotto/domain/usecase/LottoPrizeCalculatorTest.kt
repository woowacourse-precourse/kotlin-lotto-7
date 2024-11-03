package lotto.domain.usecase

import lotto.domain.model.Prize
import lotto.domain.model.PurchaseInfo
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.math.abs

class LottoPrizeCalculatorTest {
    @Test
    fun `수익률이 올바르게 계산되어야 한다`() {
        val matchResult = listOf(Prize.FIRST, Prize.THIRD)
        val purchaseInfo = PurchaseInfo(10000)
        val calculator = LottoPrizeCalculator(matchResult, purchaseInfo)
        val profitRate = calculator.calculateProfitRate()

        val expectedProfitRate = 20001500.0
        val tolerance = 0.0001
        assertEquals(false, abs(profitRate - expectedProfitRate) < tolerance)
    }
}