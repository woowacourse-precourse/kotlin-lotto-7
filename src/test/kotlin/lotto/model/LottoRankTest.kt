package lotto.model


import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoRankTest {

    @Test
    fun `getRank는 6개 일치 시 FIRST를 반환해야 한다`() {
        val rank = LottoRank.getRank(6, false)
        assertEquals(LottoRank.FIRST, rank)
    }

    @Test
    fun `getRank는 5개 일치하고 보너스가 있을 때 SECOND를 반환해야 한다`() {
        val rank = LottoRank.getRank(5, true)
        assertEquals(LottoRank.SECOND, rank)
    }

    @Test
    fun `getRank는 5개 일치하고 보너스가 없을 때 THIRD를 반환해야 한다`() {
        val rank = LottoRank.getRank(5, false)
        assertEquals(LottoRank.THIRD, rank)
    }

    @Test
    fun `getRank는 4개 일치 시 FOURTH를 반환해야 한다`() {
        val rank = LottoRank.getRank(4, false)
        assertEquals(LottoRank.FOURTH, rank)
    }

    @Test
    fun `getRank는 3개 일치 시 FIFTH를 반환해야 한다`() {
        val rank = LottoRank.getRank(3, false)
        assertEquals(LottoRank.FIFTH, rank)
    }

    @Test
    fun `getRank는 3개 미만 일치 시 NONE을 반환해야 한다`() {
        val rank1 = LottoRank.getRank(2, false)
        val rank2 = LottoRank.getRank(1, false)
        val rank3 = LottoRank.getRank(0, false)

        assertEquals(LottoRank.NONE, rank1)
        assertEquals(LottoRank.NONE, rank2)
        assertEquals(LottoRank.NONE, rank3)
    }

    @Test
    fun `getRank는 보너스 조건이 맞지 않을 경우 적절한 순위를 반환해야 한다`() {
        val rankSecond = LottoRank.getRank(5, true) // 보너스가 있을 때 THIRD가 아닌 SECOND를 반환해야 함
        val rankThird = LottoRank.getRank(5, false) // 보너스가 없을 때 SECOND가 아닌 THIRD를 반환해야 함
        assertEquals(LottoRank.SECOND, rankSecond) // THIRD가 반환되는지 확인
        assertEquals(LottoRank.THIRD, rankThird) // THIRD가 반환되는지 확인
    }
}