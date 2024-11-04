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
    fun `1등 로또 랭크를 얻는데 성공한다 - 보너스 매치가 true 일때도`() {
        val result = LottoRank.getRank(6, true)
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
    fun `4등 로또 랭크를 얻는데 성공한다 - 보너스 매치가 true 일때도`() {
        val result = LottoRank.getRank(4, true)
        assertEquals(result, LottoRank.FOURTH)
    }

    @Test
    fun `5등 로또 랭크를 얻는데 성공한다`() {
        val result = LottoRank.getRank(3, false)
        assertEquals(result, LottoRank.FIFTH)
    }

    @Test
    fun `5등 로또 랭크를 얻는데 성공한다 - 보너스 매치가 true 일때도`() {
        val result = LottoRank.getRank(3, true)
        assertEquals(result, LottoRank.FIFTH)
    }

    @Test
    fun `순위 밖의 로또 랭크를 얻는데 성공한다 - 2개 매치`() {
        val result = LottoRank.getRank(2, false)
        assertEquals(result, LottoRank.NONE)
    }

    @Test
    fun `순위 밖의 로또 랭크를 얻는데 성공한다 - 1개 매치`() {
        val result = LottoRank.getRank(1, false)
        assertEquals(result, LottoRank.NONE)
    }

    @Test
    fun `순위 밖의 로또 랭크를 얻는데 성공한다 - 0개 매치`() {
        val result = LottoRank.getRank(0, false)
        assertEquals(result, LottoRank.NONE)
    }
}
