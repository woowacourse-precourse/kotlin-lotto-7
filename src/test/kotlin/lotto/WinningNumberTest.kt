package lotto

import lotto.domain.Lotto
import lotto.domain.Rank
import lotto.domain.WinningNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class WinningNumberTest {

    private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
    private val bonusNumber = 7
    private val winningNumber = WinningNumber(winningNumbers, bonusNumber)

    @Test
    fun `로또 1등 당첨 여부 확인`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(Rank.FIRST, winningNumber.getRank(lotto))
    }

    @Test
    fun `로또 2등 당첨 여부 확인`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        assertEquals(Rank.SECOND, winningNumber.getRank(lotto))
    }

    @Test
    fun `로또 3등 당첨 여부 확인`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 10))
        assertEquals(Rank.THIRD, winningNumber.getRank(lotto))
    }

    @Test
    fun `로또 4등 당첨 여부 확인`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 10, 11))
        assertEquals(Rank.FOURTH, winningNumber.getRank(lotto))
    }

    @Test
    fun `로또 5등 당첨 여부 확인`() {
        val lotto = Lotto(listOf(1, 2, 3, 10, 11, 12))
        assertEquals(Rank.FIFTH, winningNumber.getRank(lotto))
    }
}
