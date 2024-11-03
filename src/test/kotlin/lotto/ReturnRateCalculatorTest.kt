package lotto

import lotto.domain.ReturnRateCalculator
import org.junit.jupiter.api.Test

class ReturnRateCalculatorTest {
    private val returnRateCalculator = ReturnRateCalculator()

    @Test
    fun `수익률은 소수점 둘째 자리에서 반올림한다`() {
        val cost = 1_000L
        val profit = 3_567L
        val returnRate = returnRateCalculator.calculate(cost, profit)
        assert(returnRate.toString().substringAfter(".").length == 1)
    }
}