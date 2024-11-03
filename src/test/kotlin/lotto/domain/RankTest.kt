package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RankTest {

    @Test
    fun `입력받은 로또 번호가 6개 일치하면 1등`() {
        val rank = Rank.findBy(6, false)
        assertEquals(Rank.FIRST, rank)
    }

    @Test
    fun `입력받은 로또 번호가 5개 일치하고 보너스 번호 일치하면 2등`() {
        val rank = Rank.findBy(5, true)
        assertEquals(Rank.SECOND, rank)
    }

    @Test
    fun `입력받은 로또 번호가 5개 일치하면 3등`() {
        val rank = Rank.findBy(5, false)
        assertEquals(Rank.THIRD, rank)
    }

    @Test
    fun `입력받은 로또 번호가 4개 일치하면 4등`() {
        val rank = Rank.findBy(4, false)
        assertEquals(Rank.FOURTH, rank)
    }

    @Test
    fun `입력받은 로또 번호가 3개 일치하면 5등`() {
        val rank = Rank.findBy(3, false)
        assertEquals(Rank.FIFTH, rank)
    }

    @Test
    fun `입력받은 로또 번호가 2개 이하로 일치하면 NONE`() {
        val rank = Rank.findBy(2, false)
        assertEquals(Rank.NONE, rank)
    }
}
