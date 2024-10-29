package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoRankTest {

    @Test
    fun `1등 로또 랭크를 얻는데 성공한다`() {
        val result = LottoRank.getRank(6, false)
        assertEquals(result, LottoRank.FIRST)
    }

    @Test
    fun `2등 로또 랭크를 얻는데 성공한다`() {
        val result = LottoRank.getRank(5, true)
        assertEquals(result, LottoRank.SECOND)
    }

    @Test
    fun `3등 로또 랭크를 얻는데 성공한다`() {
        val result = LottoRank.getRank(5, false)
        assertEquals(result, LottoRank.THIRD)
    }

    @Test
    fun `4등 로또 랭크를 얻는데 성공한다`() {
        val result = LottoRank.getRank(4, false)
        assertEquals(result, LottoRank.FOURTH)
    }

    @Test
    fun `5등 로또 랭크를 얻는데 성공한다`() {
        val result = LottoRank.getRank(3, false)
        assertEquals(result, LottoRank.FIFTH)
    }

    @Test
    fun `순위 밖의 로또 랭크를 얻는데 성공한다`() {
        val result = LottoRank.getRank(2, false)
        assertEquals(result, LottoRank.NONE)
    }

}
