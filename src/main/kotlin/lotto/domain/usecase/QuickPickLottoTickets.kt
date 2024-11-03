package lotto.domain.usecase

import lotto.domain.model.Lotto
import lotto.domain.model.PurchaseInfo
import lotto.util.RandomLottoNumbers

class QuickPickLottoTickets(
    private val purchaseInfo: PurchaseInfo
) {
    fun quickPickLottoTickets(): List<Lotto> {
        val quickPickLottoTickets: MutableList<Lotto> = mutableListOf()
        repeat(purchaseInfo.numberOfTickets) {
            quickPickLottoTickets.add(Lotto(RandomLottoNumbers.pick()))
        }
        return quickPickLottoTickets
    }
}