package lotto

import lotto.model.Lotto
import lotto.model.LottoRank
import lotto.model.LottoService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoServiceTest {

    private val lottoService = LottoService()

    @Test
    fun `로또_번호와_당첨_번호를_비교해_당첨_등수를_반환한다`() {

        // given
        val lottoTickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(1, 2, 3, 4, 5, 8)),
            Lotto(listOf(1, 2, 3, 4, 9, 10)),
            Lotto(listOf(1, 2, 3, 9, 10, 11)),
            Lotto(listOf(8, 9, 10, 11, 12, 13))
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        // when
        val lottoRanks = lottoService.calculateMatchingNumbers(lottoTickets, winningNumbers, bonusNumber)

        // then
        assertThat(lottoRanks).containsExactly(
            LottoRank.FIRST,
            LottoRank.SECOND,
            LottoRank.THIRD,
            LottoRank.FOURTH,
            LottoRank.FIFTH,
            LottoRank.NONE
        )
    }

    @Test
    fun `당첨_등수의_개수를_기준으로_수익률을_계산한다`() {

        // given
        val rankCount = mapOf(
            LottoRank.FIRST to 1,
            LottoRank.SECOND to 0,
            LottoRank.THIRD to 1,
            LottoRank.FOURTH to 1,
            LottoRank.FIFTH to 1,
            LottoRank.NONE to 2
        )
        val lottoAmount = 7000

        // when
        val profit = lottoService.calculateProfit(rankCount, lottoAmount)

        // then
        val expectedProfit =
            (LottoRank.FIRST.prize * 1 + LottoRank.THIRD.prize * 1 + LottoRank.FOURTH.prize * 1 +
                    LottoRank.FIFTH.prize * 1) / 7000.0

        assertThat(profit).isEqualTo(expectedProfit * 100)
    }
}