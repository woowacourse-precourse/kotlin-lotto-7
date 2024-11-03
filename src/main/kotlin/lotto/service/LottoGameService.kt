package lotto.service

import lotto.controller.dto.PurchasedLottoTicketsDto
import lotto.domain.Lotto

class LottoGameService {
    fun issueLottoTickets(purchaseAmount: Int): PurchasedLottoTicketsDto {
        val count: Int = purchaseAmount / 1000
        val lottoTickets: List<Lotto> = List(count) { Lotto.generate() }
        return PurchasedLottoTicketsDto(lottoTickets)
    }
}
