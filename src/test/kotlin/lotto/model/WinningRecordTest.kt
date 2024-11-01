package lotto.model

import lotto.model.LottoRank.Rank
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class WinningRecordTest {

    private val winningRecord = WinningRecord()

    @Test
    fun `당첨 결과에 따라 기록을 생성한다`() {
        val lottoResults = listOf(
            LottoRank(Rank.FIRST, 0),
            LottoRank(Rank.SECOND, 0),
            LottoRank(Rank.FIRST, 0),
            LottoRank(Rank.THIRD, 0),
            LottoRank(Rank.SECOND, 0),
        )

        val expected = listOf(2, 2, 1, 0, 0, 0)
        val result = winningRecord.createRecord(lottoResults)

        assertEquals(expected, result)
    }


    @ParameterizedTest
    @MethodSource("profitRateParameters")
    fun `수익률을 반환한다`(lottoResults: List<LottoRank>, purchaseAmount: Int, expected: Double) {
        val result = winningRecord.calculatorProfitRate(lottoResults, purchaseAmount)
        assertEquals(expected, result)
    }

    companion object {
        @JvmStatic
        fun profitRateParameters() = listOf(
            arrayOf(listOf(LottoRank(Rank.FIRST, 2_000_000_000)), 10_000, 20000000.0),
            arrayOf(listOf(LottoRank(Rank.SECOND, 30_000_000)), 20_000, 150000.0),
            arrayOf(listOf(LottoRank(Rank.THIRD, 1_500_000)), 5_000, 30000.0),
            arrayOf(listOf(LottoRank(Rank.FOURTH, 50_000)), 1_000, 5000.0),
            arrayOf(listOf(LottoRank(Rank.FIFTH, 5_000)), 2_000, 250.0)
        )
    }
}
