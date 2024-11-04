package lotto

import lotto.model.VerifyPrize
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EarningRateTest {
    private val verifyPrize = VerifyPrize()
    private val ticketOne = listOf(
        listOf(8, 32, 14, 5, 19, 30), // 3
        listOf(11, 31, 22, 31, 5, 9), // 0
        listOf(11, 31, 10, 13, 42, 9), // 3
        listOf(42, 1, 19, 14, 13, 33) // 4
    )
    private val ticketTwo = listOf(
        listOf(3, 32, 2, 14, 42, 44), // 3
        listOf(21, 3, 14, 25, 37, 12), // 1
        listOf(42, 10, 19, 14, 13, 3) // 5 + 1
    )
    private val prizeNumberOne = listOf(1, 2, 3, 4, 5, 6)
    private val prizeNumberTwo = listOf(42, 13, 10, 14, 32, 19)
    private val bonusNumber = 3

    @Test
    fun `수익률이 올바르게 구해지는지 확인 1`() {
        assertThat(verifyPrize.prizeResult(ticketOne, prizeNumberOne, bonusNumber)).isEqualTo(0.0)
    }

    @Test
    fun `수익률이 올바르게 구해지는지 확인 2`() {
        assertThat(verifyPrize.prizeResult(ticketOne, prizeNumberTwo, bonusNumber)).isEqualTo(1500.0)
    }

    @Test
    fun `수익률이 올바르게 구해지는지 확인 3`() {
        assertThat(verifyPrize.prizeResult(ticketTwo, prizeNumberTwo, bonusNumber)).isEqualTo(1000166.7)
    }

    @Test
    fun `수익률이 올바르게 구해지는지 확인 4`() {
        assertThat(verifyPrize.prizeResult(ticketOne + ticketTwo, prizeNumberTwo, bonusNumber)).isEqualTo(429500.0)
    }
}