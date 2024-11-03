package lotto

import camp.nextstep.edu.missionutils.test.NsTest
import controller.LottoController
import model.Lotto
import model.Prize
import model.WinningLotto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또가 우승번호와 일치하는 숫자의 개수를 반환한다`() {
        initializePrize()
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 7)), 8)
        val matchCount = lotto.matchCount(winningLotto)
        assertEquals(5, matchCount)
    }

    @Test
    fun `보너스 번호가 일치하는 지 확인한다`() {
        initializePrize()
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 7)), 6)
        val isMatchBonus = lotto.isMatchBonus(winningLotto)
        assertEquals(true, isMatchBonus)
    }

    @Test
    fun `로또 1등 당첨 여부를 반환한다`() {
        initializePrize()
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), 7)
        val matchCount = lotto.matchCount(winningLotto)
        val isMatchBonus = lotto.isMatchBonus(winningLotto)

        LottoController().updatePrize(matchCount, isMatchBonus)

        assertEquals(1, Prize.FIRST.winningCount)
    }

    @Test
    fun `로또 2등 당첨 여부를 반환한다`() {
        initializePrize()
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 7)), 6)
        val isMatchBonus = lotto.isMatchBonus(winningLotto)

        LottoController().updatePrize(5, isMatchBonus)

        assertEquals(1, Prize.SECOND.winningCount)
    }

    @Test
    fun `로또 3등 당첨 여부를 반환한다`() {
        initializePrize()
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 7)), 8)
        val matchCount = lotto.matchCount(winningLotto)
        val isMatchBonus = lotto.isMatchBonus(winningLotto)

        LottoController().updatePrize(matchCount, isMatchBonus)

        assertEquals(1, Prize.THIRD.winningCount)
    }

    @Test
    fun `로또 4등 당첨 여부를 반환한다`() {
        initializePrize()
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 8, 9)), 8)
        val matchCount = lotto.matchCount(winningLotto)
        val isMatchBonus = lotto.isMatchBonus(winningLotto)

        LottoController().updatePrize(matchCount, isMatchBonus)

        assertEquals(1, Prize.FOURTH.winningCount)
    }

    @Test
    fun `로또 5등 당첨 여부를 반환한다`() {
        initializePrize()
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 7, 8, 9)), 10)
        val matchCount = lotto.matchCount(winningLotto)
        val isMatchBonus = lotto.isMatchBonus(winningLotto)

        LottoController().updatePrize(matchCount, isMatchBonus)
        Prize.entries.forEach {
            println(it.name + " " + it.winningCount)
        }
        assertEquals(1, Prize.FIFTH.winningCount)
    }


    @Test
    fun `총 수익금액을 계산한다`() {
        initializePrize()
        val lottoes = listOf(
//            Lotto(listOf(1, 2, 3, 4, 5, 8)), // 3등
            Lotto(listOf(1, 2, 3, 41, 45, 36)), // 5등
            Lotto(listOf(1, 2, 3, 14, 35, 46)), // 5등
            Lotto(listOf(1, 2, 3, 4, 15, 36)), // 4등
        )

        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), 7)
        LottoController().calculatePrize(lottoes, winningLotto)
        val earningMoney = LottoController().calculateEarningMoney()

        assertEquals(60000, earningMoney)

    }

    @Test
    fun `총 수익률을 계산한다`() {
        initializePrize()
        val lottoes = listOf(
//            Lotto(listOf(1, 2, 3, 4, 5, 8)), // 3등
            Lotto(listOf(1, 2, 3, 41, 45, 36)), // 5등
            Lotto(listOf(1, 2, 3, 14, 35, 46)), // 5등
            Lotto(listOf(1, 2, 3, 4, 15, 36)), // 4등
        )

        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), 7)
        LottoController().calculatePrize(lottoes, winningLotto)
        val earningMoney = LottoController().calculateEarningMoney()
        val earningRate = LottoController().getEarningRate(earningMoney, 3000)

        assertEquals("2000.0%", earningRate)
    }

    companion object {
        fun initializePrize() {
            Prize.entries.forEach {
                it.winningCount = 0
            }
        }
    }
}
