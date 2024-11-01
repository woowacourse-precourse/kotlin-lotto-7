package lotto

import lotto.Model.LottoRank
import lotto.Model.WinningLottoResult
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
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
    fun testLottoSizeUnder6() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun testLottoNumNotBetween1And45() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun testLottoNumValidate() {
        assertDoesNotThrow {
            Lotto(listOf(1, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun testLottoFirstRank() {
        val winningLottoResult = makeWinningLottoResult()
        val releasedLotto = Lotto(listOf(1,2,3,4,5,6))
        assertEquals(releasedLotto.getLottoResult(winningLottoResult), LottoRank.First)
    }

    @Test
    fun testLottoSecondRank() {
        val winningLottoResult = makeWinningLottoResult()
        val releasedLotto = Lotto(listOf(1,2,3,4,5,7))
        assertEquals(releasedLotto.getLottoResult(winningLottoResult), LottoRank.Second)
    }

    @Test
    fun testLottoThirdRank() {
        val winningLottoResult = makeWinningLottoResult()
        val releasedLotto = Lotto(listOf(1,2,3,4,5,45))
        assertEquals(releasedLotto.getLottoResult(winningLottoResult), LottoRank.Third)
    }

    @Test
    fun testLottoFourthRank() {
        val winningLottoResult = makeWinningLottoResult()
        val releasedLotto = Lotto(listOf(1,2,3,4,44,45))
        assertEquals(releasedLotto.getLottoResult(winningLottoResult), LottoRank.Fourth)
    }

    @Test
    fun testLottoFifthRank() {
        val winningLottoResult = makeWinningLottoResult()
        val releasedLotto = Lotto(listOf(1,2,3,43,44,45))
        assertEquals(releasedLotto.getLottoResult(winningLottoResult), LottoRank.Fifth)
    }

    private fun makeWinningLottoResult(): WinningLottoResult {
        val winningLotto = Lotto(listOf(1,2,3,4,5,6))
        val bonusNumber = 7
        return WinningLottoResult(winningLotto, bonusNumber)
    }
}
