package lotto.controller

import lotto.controller.dto.PurchasedLottoTicketsDto
import lotto.service.LottoGameService
import lotto.view.LottoGameView

class LottoGameController(
    private val lottoGameView: LottoGameView,
    private val lottoGameService: LottoGameService
) {
    fun start() {
        val purchaseAmount: Int = lottoGameView.getPurchaseAmount()
        val purchasedLottoTickets: PurchasedLottoTicketsDto = lottoGameService.issueLottoTickets(purchaseAmount)
    }
}
