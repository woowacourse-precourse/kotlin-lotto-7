package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ProfitRateCalculatorTest {

    private val profitRateCalculator = ProfitRateCalculator()

    @Test
    fun `당첨결과와_구입금액을_입력받아_수익률을_계산하면_올바른_수익률이_반환된다`() {
        val results = mapOf(
            LottoMatchType.THREE to 1
        )
        val purchaseAmount = 8000
        val profitRate = profitRateCalculator.calculateProfitRate(results, purchaseAmount)
        val expectedProfitRate = 62.5
        assertEquals(expectedProfitRate, profitRate)
    }

    @Test
    fun `당첨결과를_입력받아_총상금을_계산하면_올바른_총상금이_반환된다`() {
        val results = mapOf(
            LottoMatchType.THREE to 10,
            LottoMatchType.FOUR to 5
        )
        val totalReward = profitRateCalculator.calculateTotalReward(results)
        val expectedTotalReward = 300000
        assertEquals(expectedTotalReward, totalReward)
    }

    @Test
    fun `상금문자열을_입력받아_정수로_변환하면_올바른_정수가_반환된다`() {
        val rewardString = "1,000,000"
        val rewardInt = profitRateCalculator.parseRewardToInt(rewardString)
        val expectedRewardInt = 1000000
        assertEquals(expectedRewardInt, rewardInt)
    }

    @Test
    fun `소수점이_있는_값을_입력받아_반올림하면_소수점_두자리까지_반올림된_값이_반환된다`() {
        val value = 1234.56789
        val roundedValue = profitRateCalculator.roundToTwoDecimalPlaces(value)
        val expectedRoundedValue = 1234.57
        assertEquals(expectedRoundedValue, roundedValue)
    }
}