package lotto

import lotto.controller.LottoController
import lotto.model.Lotto
import lotto.model.MatchType
import lotto.service.LottoCounterService
import lotto.service.LottoMatchService
import lotto.service.LottoService
import lotto.view.OutputView
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.text.DecimalFormat

class LottoServiceTest {

    @Test
    fun `구매한 로또 티켓에 대한 당첨 결과를 정확히 계산한다`() {
        val lottoService = LottoService(LottoCounterService(), LottoMatchService())
        val winningNumbers = listOf(1, 3, 5, 14, 22, 45)
        val bonusNumber = 7

        val purchasedLottoTickets = listOf(
            Lotto(listOf(8, 21, 23, 41, 42, 43)),
            Lotto(listOf(3, 5, 14, 16, 32, 38)),
            Lotto(listOf(1, 3, 5, 14, 22, 45)) // 예: 6개 일치
        )

        lottoService.setUserLottoNumbers(purchasedLottoTickets)
        lottoService.checkWinning(winningNumbers, bonusNumber)
        val result = lottoService.getMatchResult()

        assertEquals(1, result[MatchType.THREE])
        assertEquals(0, result[MatchType.FOUR])
        assertEquals(0, result[MatchType.FIVE_NOT_BONUS])
        assertEquals(0, result[MatchType.FIVE_WITH_BONUS])
        assertEquals(1, result[MatchType.SIX])
    }

    @Test
    fun `총 당첨 금액과 구매 금액을 통해 수익률을 계산한다`() {
        val lottoService = LottoService(LottoCounterService(), LottoMatchService())
        val winningNumbers = listOf(1, 3, 5, 14, 22, 45)
        val bonusNumber = 7

        val purchasedLottoTickets = listOf(
            Lotto(listOf(8, 21, 23, 41, 42, 43)),
            Lotto(listOf(3, 5, 14, 16, 32, 38)),
            Lotto(listOf(1, 3, 5, 14, 22, 45))
        )

        lottoService.setUserLottoNumbers(purchasedLottoTickets)
        lottoService.checkWinning(winningNumbers, bonusNumber)
        val decimalFormat = DecimalFormat("#,##0.00")
        val earningRate = lottoService.calculateEarningRate(3)

        assertEquals("66,666,833.33", decimalFormat.format(earningRate))
    }
}