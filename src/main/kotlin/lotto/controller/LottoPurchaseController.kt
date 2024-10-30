package lotto.controller

import lotto.model.LottoTicket

class LottoPurchaseController(private val lottoTicket: LottoTicket) {
    fun calculateNumberOfPurchase(purchaseAmount: Int) {
        val result = purchaseAmount / 1000
        lottoTicket.numberOfPurchase = result
    }

}