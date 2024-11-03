package lotto

import lotto.domain.model.Lotto
import lotto.domain.model.PurchaseInfo


object OutputView {
    private const val issueQuickPickLotto = "개를 구매했습니다."

    fun showPurchaseInfo(purchaseInfo: PurchaseInfo, quickPickLottoTickets: List<Lotto>) {
        val numberOfTickets = purchaseInfo.numberOfTickets
        println()
        println(numberOfTickets.toString() + issueQuickPickLotto)
        quickPickLottoTickets.forEach { println(it) }
        println()
    }

}