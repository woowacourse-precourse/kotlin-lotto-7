package lotto.utils

import lotto.model.Rank
import lotto.model.Stat
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class StatCalculatorTest {
    @Nested
    @DisplayName("수익률이 정상적으로 계산되는지 확인한다")
    inner class ProfitCalculatorTest {
        @Test
        fun `8000원 로또 구매 후 5등 당첨`() {
            val price = 8000
            val profit = StatCalculator.getProfitRate(listOf(Stat(Rank.FIFTH, 1)), price)

            assertThat(profit).isEqualTo("62.5")
        }

        @Test
        fun `8000원 로또 구매 후 1등 당첨`() {
            val price = 8000
            val profit = StatCalculator.getProfitRate(listOf(Stat(Rank.FIRST, 1)), price)

            assertThat(profit).isEqualTo("25000000.0")
        }

        @Test
        fun `int 범위 초과 금액 당첨 시 수익률 계산 테스트`() {
            val price = 3000
            val profit = StatCalculator.getProfitRate(listOf(Stat(Rank.FIRST, 3)), price)

            assertThat(profit).isEqualTo("200000000.0")
        }
    }

    @Nested
    @DisplayName("당첨 등수가 제대로 계산되는지 확인한다")
    inner class RankCalculatorTest {
        @Test
        fun `6개 일치로 1등 당첨`() {
            val rank = StatCalculator.getRank(listOf(1, 2, 3, 4, 5, 6), setOf(1, 2, 3, 4, 5, 6), 7)
            assertThat(rank).isEqualTo(Rank.FIRST)
        }

        @Test
        fun `5개 + 보너스볼 일치로 2등 당첨`() {
            val rank = StatCalculator.getRank(listOf(1, 2, 3, 4, 5, 6), setOf(1, 2, 3, 4, 5, 7), 6)
            assertThat(rank).isEqualTo(Rank.SECOND)
        }

        @Test
        fun `5개 일치로 3등 당첨`() {
            val rank = StatCalculator.getRank(listOf(1, 2, 3, 4, 5, 6), setOf(1, 2, 3, 4, 5, 7), 8)
            assertThat(rank).isEqualTo(Rank.THIRD)
        }
    }
}