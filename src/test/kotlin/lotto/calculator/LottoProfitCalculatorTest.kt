package lotto.calculator

import lotto.enums.Rank
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoProfitCalculatorTest {

    @Test
    fun `수익률 계산 - 당첨이 없는 경우`() {
        val lottoStats = listOf<Rank>() // 당첨 통계가 없음
        val amount = 10000 // 구입 금액

        val calculator = LottoProfitCalculator(lottoStats, amount)


        assertEquals(0.0, calculator.getLottoProfit(), "당첨이 없으므로 수익률은 0%여야 합니다.")
    }

    @Test
    fun `수익률 계산 - 일부 당첨된 경우`() {
        val lottoStats = listOf(
            Rank.FIFTH,
            Rank.FIFTH,
            Rank.THIRD
        )
        val amount = 10000

        val calculator = LottoProfitCalculator(lottoStats, amount)


        // 5등 (5,000원) 2개 + 3등 (1,500,000원) 1개 => 총 당첨금 = 5,000*2 + 1,500,000 = 1,510,000원
        assertEquals(15100.0, calculator.getLottoProfit(), "당첨금이 1,510,000원이므로 수익률은 1510%여야 합니다.")
    }

    @Test
    fun `수익률 계산 - 전부 당첨된 경우`() {
        val lottoStats = listOf(
            Rank.FIRST,
            Rank.SECOND
        )
        val amount = 10000

        val calculator = LottoProfitCalculator(lottoStats, amount)


        // 1등 (2,000,000,000원) + 2등 (30,000,000원) => 총 당첨금 = 2,000,000,000 + 30,000,000 = 2,030,000,000원
        assertEquals(20300000.0, calculator.getLottoProfit(), "당첨금이 2,030,000,000원이므로 수익률은 2030000%여야 합니다.")
    }
}
