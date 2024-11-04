package lotto

import lotto.controller.LottoController
import lotto.controller.MatchingLottoCount
import lotto.model.Lotto
import lotto.model.LottoMatchCount
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
        val money = 5000
        // 번호 6개가 일치 하는 로또가 1개
        val matchCount = mapOf(MatchingLottoCount.THREE to 1)
        LottoMatchCount.calculateProfit(matchCount)
        val profit = LottoMatchCount.getProfit()
        val amountOfProfit = LottoMatchCount.calculateAmountOfProfit(profit, money)
        assertEquals(amountOfProfit, 100.0f)
    }

    @Test
    fun `로또 수익률 계산(당첨자 5명- 전원)`() {
        val money = 5000
        // 번호 6개가 일치 하는 로또가 1개
        val matchCount = mapOf(MatchingLottoCount.THREE to 5)
        LottoMatchCount.calculateProfit(matchCount)
        val profit = LottoMatchCount.getProfit()
        val amountOfProfit = LottoMatchCount.calculateAmountOfProfit(profit, money)
        assertEquals(amountOfProfit, 500.0f)
    }
}