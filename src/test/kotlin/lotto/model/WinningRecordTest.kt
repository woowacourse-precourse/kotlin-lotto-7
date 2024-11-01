package lotto.model

import lotto.model.LottoRank.Rank
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

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
}
