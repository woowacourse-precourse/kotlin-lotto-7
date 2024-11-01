package lotto

import domain.enums.Rank
import domain.lotto.Lotto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RankTest {

    @Test
    fun `matchingCount가 6일 때 FIRST 랭크가 반환되는지 테스트`() {
        val rank = Rank.getRank(matchingCount = 6, bonusMatched = false)

        val actual = Rank.FIRST

        assertEquals(rank, actual)
    }

    @Test
    fun `matchingCount가 5이고 보너스 번호가 일치할 때 SECOND 랭크가 반환되는지 테스트`() {
        val rank = Rank.getRank(matchingCount = 5, bonusMatched = true)

        val actual = Rank.SECOND

        assertEquals(rank, actual)
    }

    @Test
    fun `matchingCount가 5이고 보너스 번호가 불일치할 때 THIRD 랭크가 반환되는지 테스트`() {
        val rank = Rank.getRank(matchingCount = 5, bonusMatched = false)

        val actual = Rank.THIRD

        assertEquals(rank, actual)
    }

    @Test
    fun `matchingCount가 4일 때 FOURTH 랭크가 반환되는지 테스트`() {
        val rank = Rank.getRank(matchingCount = 4, bonusMatched = false)

        val actual = Rank.FOURTH

        assertEquals(actual, rank)
    }

    @Test
    fun `matchingCount가 3일 때 FIFTH 랭크가 반환되는지 테스트`() {
        val rank = Rank.getRank(matchingCount = 3, bonusMatched = false)

        val actual = Rank.FIFTH

        assertEquals(actual, rank)
    }

    @Test
    fun `matchingCount가 2일 때 NONE 랭크가 반환되는지 테스트`() {
        val rank = Rank.getRank(matchingCount = 2, bonusMatched = false)

        val actual = Rank.NONE

        assertEquals(actual, rank)
    }
}