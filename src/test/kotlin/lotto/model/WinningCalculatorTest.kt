package lotto.model

import lotto.util.Prize
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class WinningCalculatorTest {

    @Test
    fun `당첨 내역을 올바르게 계산한다`() {
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7
        val purchasedLottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),  // 1등
            Lotto(listOf(1, 2, 3, 4, 5, 7)),  // 2등
            Lotto(listOf(1, 2, 3, 4, 5, 8)),  // 3등
            Lotto(listOf(1, 2, 3, 4, 10, 11)),  // 4등
            Lotto(listOf(1, 2, 3, 8, 9, 10))   // 5등
        )

        val winningDetails = WinningCalculator().calculateDetails(winningLotto, bonusNumber, purchasedLottos)

        assertEquals(listOf(1, 1, 1, 1, 1), winningDetails, "당첨 내역이 올바르지 않습니다.")
    }

    @Test
    fun `수익률을 올바르게 계산한다`() {
        val moneySpent = 5000
        val winningDetails = mutableListOf(1, 0, 0, 0, 0)  // 1등 1개 당첨
        val expectedPrize = Prize.FIRST.prize

        val returnRate = WinningCalculator().calculateReturnRate(moneySpent, winningDetails)

        assertEquals(expectedPrize.toDouble() / moneySpent * 100, returnRate, "수익률 계산이 올바르지 않습니다.")
    }

}