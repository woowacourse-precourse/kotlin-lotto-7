package lotto.controller

import lotto.model.Lotto
import lotto.model.LottoNumberGenerator
import lotto.model.LottoTicket

class LottoPurchaseController(
    private val lottoTicket: LottoTicket,
    private val lottoNumberGenerator: LottoNumberGenerator
) {
    fun calculateNumberOfPurchase(purchaseAmount: Int) {
        val result = purchaseAmount / 1000
        lottoTicket.numberOfPurchase = result
    }

    fun saveUserLottoNumbers() {
        val lottoTickets = mutableListOf<Lotto>()
        repeat(lottoTicket.numberOfPurchase) {
            lottoTickets.add(lottoNumberGenerator.generateNumbers())
        }
        lottoTicket.userLottoNumbers = lottoTickets
    }

}