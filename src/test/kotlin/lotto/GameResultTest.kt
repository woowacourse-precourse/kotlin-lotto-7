package lotto

import lotto.domain.GameResult
import lotto.domain.Rank
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GameResultTest {

    private val gameResult = GameResult()

    @Test
    fun `로또 당첨 내역 확인`() {
        gameResult.addWinningDetail(Rank.FIRST)
        gameResult.addWinningDetail(Rank.FIRST)
        gameResult.addWinningDetail(Rank.FIRST)

        assertEquals(3, gameResult.winningDetail[Rank.FIRST])
    }

    @Test
    fun `로또 당첨 수익률 확인`() {
        gameResult.addWinningDetail(Rank.FOURTH)
        gameResult.addWinningDetail(null)

        assertEquals(25.0, gameResult.getEarningRate())
    }
}