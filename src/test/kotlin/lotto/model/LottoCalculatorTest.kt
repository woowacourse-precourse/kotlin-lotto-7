package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoCalculatorTest {

    private val calculator = LottoCalculator()

    @Test
    fun `수익률을 올바르게 계산한다 - 손해인 경우`() {
        val results = mapOf(
            Rank.FIFTH to 1,
            Rank.NONE to 0
        )
        val purchasePrice = 10000

        val profitRate = calculator.calculateProfitRate(results, purchasePrice)

        assertThat(profitRate).isEqualTo("50.0")
    }

    @Test
    fun `수익률을 올바르게 계산한다 - 본전인 경우`() {
        val results = mapOf(
            Rank.FIFTH to 2
        )
        val purchasePrice = 10000

        val profitRate = calculator.calculateProfitRate(results, purchasePrice)

        assertThat(profitRate).isEqualTo("100.0")
    }

    @Test
    fun `수익률을 올바르게 계산한다 - 이익인 경우`() {
        val results = mapOf(
            Rank.FOURTH to 1,
            Rank.FIFTH to 1
        )
        val purchasePrice = 10000

        val profitRate = calculator.calculateProfitRate(results, purchasePrice)

        assertThat(profitRate).isEqualTo("550.0")
    }

    @Test
    fun `수익률을 올바르게 계산한다 - 당첨이 없는 경우`() {
        val results = mapOf(
            Rank.NONE to 1
        )
        val purchasePrice = 10000

        val profitRate = calculator.calculateProfitRate(results, purchasePrice)

        assertThat(profitRate).isEqualTo("0.0")
    }
}
