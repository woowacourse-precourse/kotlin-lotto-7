package lotto.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoStatisticsTest {

    private lateinit var lottoStatistics: LottoStatistics

    @BeforeEach
    fun setUp() {
        lottoStatistics = LottoStatistics()
    }

    @Test
    fun `랭크 카운트를 증가시키면 해당 랭크의 카운트가 증가한다`() {
        // Given
        val rank = Rank.FIRST

        // When
        lottoStatistics.incrementRankCount(rank)

        // Then
        assertEquals(1, lottoStatistics.getRankCount(rank))
    }

    @Test
    fun `랭크 카운트를 증가시키지 않으면 해당 랭크의 카운트는 0이다`() {
        // Given
        val rank = Rank.SECOND

        // When
        val count = lottoStatistics.getRankCount(rank)

        // Then
        assertEquals(0, count)
    }

    @Test
    fun `총 상금을 계산하면 올바른 금액이 반환된다`() {
        // Given
        val rankFirst = Rank.FIRST
        val rankSecond = Rank.SECOND

        lottoStatistics.incrementRankCount(rankFirst)
        lottoStatistics.incrementRankCount(rankSecond)
        lottoStatistics.incrementRankCount(rankSecond)

        val expectedTotalPrize = rankFirst.getPrize().toLong() + 2 * rankSecond.getPrize().toLong()

        // When
        val totalPrize = lottoStatistics.getTotalPrize()

        // Then
        assertEquals(expectedTotalPrize, totalPrize)
    }
}
