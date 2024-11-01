package lotto

import lotto.model.VerifyPrize
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EarningRateTest {
    private val verifyPrize = VerifyPrize()
    private val ticketOne = listOf(
        listOf(8, 32, 14, 5, 19, 30),
        listOf(11, 31, 22, 31, 5, 9),
        listOf(11, 31, 10, 13, 42, 9),
        listOf(42, 1, 19, 14, 13, 33)
    )
    private val ticketTwo = listOf(
        listOf(3, 32, 2, 14, 42, 44),
        listOf(21, 3, 14, 25, 37, 12),
        listOf(42, 10, 19, 14, 13, 3)
    )
    private val prizeNumber = listOf(42, 13, 10, 14, 32, 19)
    private val bonusNumber = 3

    @Test
    fun `수익률이 올바르게 구해지는지 확인 1`() {
        assertThat(verifyPrize.prizeResult(ticketOne, prizeNumber, bonusNumber)).isEqualTo(1500.0)
    }

    @Test
    fun `수익률이 올바르게 구해지는지 확인 2`() {
        assertThat(verifyPrize.prizeResult(ticketTwo, prizeNumber, bonusNumber)).isEqualTo(1000166.7)
    }
}