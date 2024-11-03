package lotto

import lotto.controller.LottoResultChecker
import lotto.model.Lotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class LottoResultCheckerTest {
    @Test
    fun `checkWinningStatus함수가 의도한 값을 반환하는지 확인`() {
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)), // 1등
            Lotto(listOf(1, 2, 3, 4, 5, 7)), // 2등 (보너스 포함)
            Lotto(listOf(1, 2, 3, 4, 5, 8)), // 3등
            Lotto(listOf(1, 2, 3, 4, 9, 10)), // 4등
            Lotto(listOf(1, 2, 3, 11, 12, 13)) // 5등
        )

        val myLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val myBonus = 7

        val (winningCounts, bonusWin) = LottoResultChecker.checkWinningStatus(lottos, myLotto, myBonus)

        assertEquals(listOf(0, 0, 0, 1, 1, 1, 1), winningCounts)
        assertEquals(1, bonusWin)
    }

    @Test
    fun `수익률 정상적으로 계산하는지 확인`() {
        val winningCounts = listOf(0, 0, 0, 1, 1, 1, 1)
        val bonusWin = 1
        val money = 5000
        val profitRate = LottoResultChecker.calculateProfitRate(money, winningCounts, bonusWin)
        assertEquals(profitRate, (2000000000 + 30000000 + 1500000 + 50000 + 5000)/money.toDouble())
    }
}