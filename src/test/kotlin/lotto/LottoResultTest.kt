package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoResultTest {

    private lateinit var lottoResult: LottoResult
    private lateinit var expectedLottoList: List<Lotto>
    private lateinit var expectedWinningNumbers: List<Int>
    private lateinit var expectedLottoRankList: List<LottoRank>
    private var expectedRateOfReturn: Double = 0.0

    @BeforeEach
    fun setUp() {
        expectedLottoList = listOf(Lotto(listOf(1,2,3,4,5,6)))
        expectedWinningNumbers = listOf(1,2,3,30,31,32)
        expectedLottoRankList = listOf(LottoRank.THREE_MATCHES)
        expectedRateOfReturn = (LottoRank.THREE_MATCHES.price / 1000).toDouble() * 100
        lottoResult = LottoResult(expectedLottoList, expectedWinningNumbers, BONUS_NUMBER)
    }

    @Test
    fun `로또 당첨 통계 테스트`() {
        val actual = lottoResult.getResult()
        assertEquals(expectedRateOfReturn, actual.rateOfReturn)
        assertEquals(expectedLottoRankList, actual.lottoRankList)
    }

    companion object {
        private const val BONUS_NUMBER = 35
    }
}