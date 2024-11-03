package lotto.controller

import lotto.controller.dto.PurchasedLottoNumbersDto
import lotto.controller.dto.PurchasedLottoTicketsDto
import lotto.controller.dto.WinningProfitRateDto
import lotto.controller.dto.WinningStatisticsDto
import lotto.service.LottoGameService
import lotto.view.LottoGameView

class LottoGameController(
    private val lottoGameView: LottoGameView,
    private val lottoGameService: LottoGameService
) {
    fun start() {
        val purchaseAmount: Int = lottoGameView.getPurchaseAmount()
        val purchasedLottoTickets: PurchasedLottoTicketsDto = lottoGameService.issueLottoTickets(purchaseAmount)
        lottoGameView.displayPurchasedLottoTickets(purchaseAmount, purchasedLottoTickets)

        val purchasedLottoNumbers: PurchasedLottoNumbersDto = lottoGameView.getPurchasedLottoNumbers()
        val results: WinningStatisticsDto =
            lottoGameService.calculateResults(purchasedLottoTickets, purchasedLottoNumbers)
        val profitRate: WinningProfitRateDto = lottoGameService.calculateProfitRate(results, purchaseAmount)
        lottoGameView.displayLottoGameResults(results, profitRate)
    }
}
