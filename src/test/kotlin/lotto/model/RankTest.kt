package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RankTest {

    @Test
    fun `FIRST 랭크가 반환`() {
        val rank = Rank.findRank(6, false)
        assertEquals(Rank.FIRST, rank)
    }

    @Test
    fun `SECOND 랭크가 반환`() {
        val rank = Rank.findRank(5, true)
        assertEquals(Rank.SECOND, rank)
    }

    @Test
    fun `THIRD 랭크가 반환`() {
        val rank = Rank.findRank(5, false)
        assertEquals(Rank.THIRD, rank)
    }

    @Test
    fun `FOURTH 랭크가 반환`() {
        val rank = Rank.findRank(4, false)
        assertEquals(Rank.FOURTH, rank)
    }

    @Test
    fun `FIFTH 랭크가 반환`() {
        val rank = Rank.findRank(3, false)
        assertEquals(Rank.FIFTH, rank)
    }

    @Test
    fun `NONE 랭크가 반환`() {
        val rank = Rank.findRank(0, false)
        assertEquals(Rank.NONE, rank)
    }
}
