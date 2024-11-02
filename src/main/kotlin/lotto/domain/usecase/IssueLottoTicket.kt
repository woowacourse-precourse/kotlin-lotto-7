package lotto.domain.usecase

import lotto.domain.model.Lotto
import lotto.domain.model.PurchaseInfo
import lotto.util.RandomLottoNumbers

class IssueLottoTicket(
    private val numberOfTickets: PurchaseInfo
) {
    fun issueLotto(): List<Lotto> {
        val lottoTickets: MutableList<Lotto> = mutableListOf()
        repeat(numberOfTickets.getNumberOfTickets()) {
            lottoTickets.add(Lotto(RandomLottoNumbers.pick()))
        }
        return lottoTickets
    }
}