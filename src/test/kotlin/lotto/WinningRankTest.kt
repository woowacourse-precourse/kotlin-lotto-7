package lotto

import lotto.domain.WinningRank
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WinningRankTest {
    @Test
    fun `6개 일치 시 1등을 반환한다`() {
        val rank = WinningRank.findByMatch(6)
        assertEquals(WinningRank.SIX_MATCH, rank)
    }

    @Test
    fun `5개 일치 시 3등을 반환한다`() {
        val rank = WinningRank.findByMatch(5, matchBonus = false)
        assertEquals(WinningRank.FIVE_MATCH, rank)
    }

    @Test
    fun `5개 일치 및 보너스 번호 일치 시 2등을 반환한다`() {
        val rank = WinningRank.findByMatch(5, matchBonus = true)
        assertEquals(WinningRank.FIVE_MATCH_WITH_BONUS, rank)
    }

    @Test
    fun `3개 일치 시 5등을 반환한다`() {
        val rank = WinningRank.findByMatch(3)
        assertEquals(WinningRank.THREE_MATCH, rank)
    }

    @Test
    fun `일치하는 번호가 없을 시 등수가 없다`() {
        val rank = WinningRank.findByMatch(1)
        assertEquals(WinningRank.NO_MATCH, rank)
    }
}