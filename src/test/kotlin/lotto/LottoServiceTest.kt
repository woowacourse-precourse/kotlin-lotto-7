package lotto

import lotto.model.Lotto
import lotto.service.LottoService
import lotto.utils.LottoMatchDescription
import lotto.utils.LottoMatchPrize
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoServiceTest {
    @Test
    fun `로또 구매 개수 계산 테스트`() {
        val lottoService = LottoService()
        val lottos = lottoService.purchaseLottos(5000)
        assertEquals(5, lottos.size)
    }

    @Test
    fun `당첨 통계 계산 - 3개 일치`() {
        val lottoService = LottoService()
        val lottos = listOf(Lotto(listOf(1, 2, 3, 7, 8, 9)))
        val winningNumbers = listOf(1, 2, 3, 10, 11, 12)
        val statistics = lottoService.calculateStatistics(lottos, winningNumbers, 13)

        assertEquals(1, statistics[LottoMatchDescription.MATCH_3_DESCRIPTION.description])
    }

    @Test
    fun `당첨 통계 계산 - 5개 일치 + 보너스 번호`() {
        val lottoService = LottoService()
        val lottos = listOf(Lotto(listOf(1, 2, 3, 4, 5, 7)))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val statistics = lottoService.calculateStatistics(lottos, winningNumbers, bonusNumber)

        assertEquals(1, statistics[LottoMatchDescription.MATCH_5_BONUS_DESCRIPTION.description])
    }

    @Test
    fun `당첨 통계 계산 - 6개 일치`() {
        val lottoService = LottoService()
        val lottos = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val statistics = lottoService.calculateStatistics(lottos, winningNumbers, 7)

        assertEquals(1, statistics[LottoMatchDescription.MATCH_6_DESCRIPTION.description])
    }

    @Test
    fun `수익률 계산 테스트`() {
        val lottoService = LottoService()
        val statistics = mapOf(
            LottoMatchDescription.MATCH_3_DESCRIPTION.description to 1,
            LottoMatchDescription.MATCH_4_DESCRIPTION.description to 0,
            LottoMatchDescription.MATCH_5_DESCRIPTION.description to 0,
            LottoMatchDescription.MATCH_5_BONUS_DESCRIPTION.description to 0,
            LottoMatchDescription.MATCH_6_DESCRIPTION.description to 0
        )
        val profitRate = lottoService.calculateRateOfReturn(statistics)
        assertEquals(5000, profitRate)
    }

    @Test
    fun `6개 번호가 일치할 때 수익률 계산`() {
        val lottoService = LottoService()
        val statistics = mapOf(
            LottoMatchDescription.MATCH_3_DESCRIPTION.description to 0,
            LottoMatchDescription.MATCH_4_DESCRIPTION.description to 0,
            LottoMatchDescription.MATCH_5_DESCRIPTION.description to 0,
            LottoMatchDescription.MATCH_5_BONUS_DESCRIPTION.description to 0,
            LottoMatchDescription.MATCH_6_DESCRIPTION.description to 1
        )
        val profitRate = lottoService.calculateRateOfReturn(statistics)
        assertEquals(LottoMatchPrize.MATCH_6_PRIZE.prize, profitRate)
    }
}