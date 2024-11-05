package lotto

import lotto.model.LottoRank
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoRankTest {

    @Test
    fun `6개 번호가 모두 일치하면 1등을 반환한다`() {
        val matchCount = 6
        val isBonusMatch = false

        val rank = LottoRank.fromMatchCount(matchCount, isBonusMatch)

        assertEquals(LottoRank.FIRST, rank)
    }

    @Test
    fun `5개 번호가 일치하고 보너스 번호도 일치하면 2등을 반환한다`() {
        val matchCount = 5
        val isBonusMatch = true

        val rank = LottoRank.fromMatchCount(matchCount, isBonusMatch)

        assertEquals(LottoRank.SECOND, rank)
    }

    @Test
    fun `5개 번호만 일치하고 보너스 번호는 불일치하면 3등을 반환한다`() {
        val matchCount = 5
        val isBonusMatch = false

        val rank = LottoRank.fromMatchCount(matchCount, isBonusMatch)

        assertEquals(LottoRank.THIRD, rank)
    }

    @Test
    fun `4개 번호가 일치하면 4등을 반환한다`() {
        val matchCount = 4
        val isBonusMatch = false

        val rank = LottoRank.fromMatchCount(matchCount, isBonusMatch)

        assertEquals(LottoRank.FOURTH, rank)
    }

    @Test
    fun `3개 번호가 일치하면 5등을 반환한다`() {
        val matchCount = 3
        val isBonusMatch = false

        val rank = LottoRank.fromMatchCount(matchCount, isBonusMatch)

        assertEquals(LottoRank.FIFTH, rank)
    }

    @Test
    fun `2개 이하의 번호가 일치하면 낙첨을 반환한다`() {
        val matchCount = 2
        val isBonusMatch = false

        val rank = LottoRank.fromMatchCount(matchCount, isBonusMatch)

        assertEquals(LottoRank.NONE, rank)
    }
}
