package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LottoWinningResultCalculatorTest {

    val calculator = LottoWinningResultCalculator()

    @Test
    fun 입력_모든_번호가_일치하지_않을_때_미당첨() {
        val purchasedLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(7, 8, 9, 10, 11, 12)
        val bonusNumber = 13
        val results = mutableMapOf<LottoMatchType, Int>()

        calculator.processLottoResult(purchasedLotto, winningNumbers, bonusNumber, results)

        assertTrue(results.isEmpty())
    }

    @Test
    fun 입력_3개_번호가_일치할_때_3개_당첨() {
        val purchasedLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 4, 10, 11, 12)
        val bonusNumber = 13
        val results = mutableMapOf<LottoMatchType, Int>()

        calculator.processLottoResult(purchasedLotto, winningNumbers, bonusNumber, results)

        assertEquals(1, results[LottoMatchType.THREE])
    }

    @Test
    fun 입력_4개_번호가_일치할_때_4개_당첨() {
        val purchasedLotto = Lotto(listOf(1, 5, 10, 15, 20, 25))
        val winningNumbers = listOf(1, 2, 5, 13, 15, 25)
        val bonusNumber = 13
        val results = mutableMapOf<LottoMatchType, Int>()

        calculator.processLottoResult(purchasedLotto, winningNumbers, bonusNumber, results)

        assertEquals(1, results[LottoMatchType.FOUR])
    }

    @Test
    fun 입력_5개_번호가_일치할_때_5개_당첨() {
        val purchasedLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 12)
        val bonusNumber = 13
        val results = mutableMapOf<LottoMatchType, Int>()

        calculator.processLottoResult(purchasedLotto, winningNumbers, bonusNumber, results)

        assertEquals(1, results[LottoMatchType.FIVE])
    }

    @Test
    fun 입력_5개_번호와_보너스_번호가_일치할_때_5개_보너스_당첨() {
        val purchasedLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 12)
        val bonusNumber = 6
        val results = mutableMapOf<LottoMatchType, Int>()

        calculator.processLottoResult(purchasedLotto, winningNumbers, bonusNumber, results)

        assertEquals(1, results[LottoMatchType.FIVE_BONUS])
    }

    @Test
    fun 입력_6개_번호가_일치할_때_6개_당첨() {
        val purchasedLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 13
        val results = mutableMapOf<LottoMatchType, Int>()

        calculator.processLottoResult(purchasedLotto, winningNumbers, bonusNumber, results)

        assertEquals(1, results[LottoMatchType.SIX])
    }
}