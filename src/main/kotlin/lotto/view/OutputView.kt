package lotto.view

import lotto.domain.model.Lotto
import lotto.domain.model.Prize
import lotto.domain.model.PurchaseInfo


object OutputView {
    private const val ISSUE_QUICK_PICK_LOTTO = "개를 구매했습니다."
    private const val LOTTO_PRIZE = "\n당첨 통계"
    private const val DASH = "---"
    private const val PROFIT_RATE = "총 수익률은 %.2f%%입니다."
    private const val PROFIT_RATE_SIMPLE = "총 수익률은 %.1f%%입니다."
    private const val ZERO = 0
    private const val RANK_MESSAGE = "%d개 일치 (%s원) - %d개"
    private const val SECOND_RANK_MESSAGE = "5개 일치, 보너스 볼 일치 (%s원) - %d개"


    fun showPurchaseInfo(purchaseInfo: PurchaseInfo, quickPickLottoTickets: List<Lotto>) {
        val numberOfTickets = purchaseInfo.numberOfTickets
        println()
        println(numberOfTickets.toString() + ISSUE_QUICK_PICK_LOTTO)
        quickPickLottoTickets.forEach { println(it) }
        println()
    }

    fun showCalculateInfo(matchResult: List<Prize>) {
        println(LOTTO_PRIZE)
        println(DASH)
        val prizeCount = matchResult.groupingBy { it }.eachCount()
        Prize.entries.filter { it != Prize.NONE }.forEach { prize ->
            val count = prizeCount[prize] ?: ZERO
            val result = when (prize) {
                Prize.SECOND -> String.format(SECOND_RANK_MESSAGE, prize.prizeAmount, count)
                else -> String.format(RANK_MESSAGE,prize.matchingNumberCount, prize.prizeAmount, count)
            }
            println(result)
        }
    }

    fun showProfit(profitRate: Double) {
        val message = if (profitRate * 10 % 1 == 0.0) {
            String.format(PROFIT_RATE_SIMPLE, profitRate)
        } else {
            String.format(PROFIT_RATE, profitRate)
        }
        println(message)
    }
}