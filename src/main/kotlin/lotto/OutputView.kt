package lotto

import lotto.domain.model.Lotto
import lotto.domain.model.Prize
import lotto.domain.model.PurchaseInfo


object OutputView {
    private const val ISSUE_QUICK_PICK_LOTTO = "개를 구매했습니다."
    private const val PROFIT_RATE = "총 수익률은 %.2f%%입니다."



    fun showPurchaseInfo(purchaseInfo: PurchaseInfo, quickPickLottoTickets: List<Lotto>) {
        val numberOfTickets = purchaseInfo.numberOfTickets
        println()
        println(numberOfTickets.toString() + ISSUE_QUICK_PICK_LOTTO)
        quickPickLottoTickets.forEach { println(it) }
        println()
    }

    fun showProfit(profitRate: Double) {
        val message = String.format(PROFIT_RATE, profitRate)
        println(message)
    }
}