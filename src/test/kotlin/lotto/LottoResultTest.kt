package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoResultTest {

    private lateinit var lottoResult: LottoResult
    private lateinit var expectedLottoList: List<Lotto>
    private lateinit var expectedWinningNumbersWithThreeMatches: List<Int>
    private lateinit var expectedWinningNumbersWithBonusNumber: List<Int>
    private lateinit var expectedLottoRankList: List<LottoRank>
    private var expectedRateOfReturn: Double = 0.0

    @BeforeEach
    fun setUp() {
        expectedLottoList = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        expectedWinningNumbersWithThreeMatches = listOf(1, 2, 3, 30, 31, 32)
        expectedWinningNumbersWithBonusNumber = listOf(1, 2, 3, 4, 5, 10)
    }

    @Test
    fun `로또번호와 당첨번호 비교 후 당첨 통계 테스트`() {
        lottoResult = LottoResult(expectedLottoList, expectedWinningNumbersWithThreeMatches, BONUS_NUMBER)
        expectedRateOfReturn = (LottoRank.THREE_MATCHES.price / 1000).toDouble() * 100
        expectedLottoRankList = listOf(LottoRank.THREE_MATCHES)

        val actual = lottoResult.getResult()

        assertEquals(expectedRateOfReturn, actual.rateOfReturn)
        assertEquals(expectedLottoRankList, actual.lottoRankList)
    }

    @Test
    fun `로또번호와 보너스 번호 당첨 통계 테스트`() {
        lottoResult =
            LottoResult(expectedLottoList, expectedWinningNumbersWithBonusNumber, BONUS_NUMBER)
        expectedRateOfReturn = (LottoRank.FIVE_AND_BONUS_MATCHES.price / 1000).toDouble() * 100
        expectedLottoRankList = listOf(LottoRank.FIVE_AND_BONUS_MATCHES)

        val actual = lottoResult.getResult()

        assertEquals(expectedRateOfReturn, actual.rateOfReturn)
        assertEquals(expectedLottoRankList, actual.lottoRankList)
    }

    companion object {
        private const val BONUS_NUMBER = 6
    }
}