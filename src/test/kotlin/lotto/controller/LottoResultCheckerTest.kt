package lotto.controller

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

        val ranking = LottoResultChecker.checkWinningStatus(lottos, myLotto, myBonus)

        assertEquals(listOf(0, 1, 1, 1, 1, 1), ranking)
    }

    @Test
    fun `compareLotto 겹치는 개수 정상적으로 계산하는지 확인`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val myLotto = Lotto(listOf(1, 2, 3, 4, 5, 9))
        val myBonus = 6
        val (duplicateCount, isBonus) = LottoResultChecker.compareLotto(lotto, myLotto, myBonus)
        assertEquals(duplicateCount, 5)
        assertEquals(isBonus, true)
    }

    @Test
    fun `수익률 정상적으로 계산하는지 확인`() {
        val ranking = listOf(0, 1, 1, 1, 1, 1)
        val money = 5000
        val profitRate = LottoResultChecker.calculateProfitRate(money, ranking)
        assertEquals(profitRate, (2000000000 + 30000000 + 1500000 + 50000 + 5000) / money.toDouble())
    }
}