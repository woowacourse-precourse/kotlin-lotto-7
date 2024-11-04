package lotto

import lotto.model.Lotto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoProfitCalcTest {

    @Test
    fun `로또 수익률 계산(당첨자 0명)`() {
        val winLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val purchaseLotto = Lotto(listOf(7, 8, 9, 10, 11, 12))
        val bonusNumber = 13
        val matchCount = purchaseLotto.getMatchCount(winLotto)
        val isBonusMatch = purchaseLotto.isMatchBonusNumber(bonusNumber)
        assertEquals(matchCount, 0)
        assertEquals(isBonusMatch, false)
    }

    @Test
    fun `로또 수익률 계산(당첨자 1명)`() {
        val winLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val purchaseLotto = listOf(Lotto(listOf(7, 8, 9, 10, 11, 12)), Lotto(listOf(13, 14, 15, 16, 17, 18)))
        val bonusNumber = 13
//        val matchCount = purchaseLotto.getMatchCount(winLotto)
//        val isBonusMatch = purchaseLotto.isMatchBonusNumber(bonusNumber)
//        assertEquals(matchCount, 0)
//        assertEquals(isBonusMatch, false)
    }
}