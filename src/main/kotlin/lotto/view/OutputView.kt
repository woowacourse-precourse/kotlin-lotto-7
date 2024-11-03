package lotto.view

import lotto.domain.entity.Lotto
import lotto.domain.entity.WinningLotto
import lotto.domain.entity.toPriceString

class OutputView {
    fun showRandomLottos(lottos: List<Lotto>) {
        println("\n${lottos.size}$LOTTO_PURCHASE_MSG")
        lottos.forEach { println(it) }
        println()
    }

    fun showStatus() {
        println(WIN_STATUS_MSG)
        println("$THREE$SAME_NUM_MSG (${WinningLotto.Three.toPriceString()}$WON) $DELIMIETER ${WinningLotto.Three.amount}$AMOUNT")
        println("$FOUR$SAME_NUM_MSG (${WinningLotto.Four.toPriceString()}$WON) $DELIMIETER ${WinningLotto.Four.amount}$AMOUNT")
        println("$FIVE$SAME_NUM_MSG (${WinningLotto.Five.toPriceString()}$WON) $DELIMIETER ${WinningLotto.Five.amount}$AMOUNT")
        println("$FIVE$SAME_NUM_MSG$BONUS_SAME_MSG (${WinningLotto.FiveBonus.toPriceString()}$WON) $DELIMIETER ${WinningLotto.FiveBonus.amount}$AMOUNT")
        println("$SIX$SAME_NUM_MSG (${WinningLotto.Six.toPriceString()}$WON) $DELIMIETER ${WinningLotto.Six.amount}$AMOUNT")
    }

    fun showProfitRate(profitRate: String) {
        println("$PROFIT_RATE_MSG1$profitRate$PROFIT_RATE_MSG2")
    }

    companion object {
        const val LOTTO_PURCHASE_MSG = "개를 구매했습니다."

        const val WIN_STATUS_MSG = "\n당첨 통계\n---"
        const val SAME_NUM_MSG = "개 일치"

        const val DELIMIETER = "-"
        const val WON = "원"
        const val AMOUNT = "개"

        const val THREE = 3
        const val FOUR = 4
        const val FIVE = 5
        const val BONUS_SAME_MSG = ", 보너스 볼 일치"
        const val SIX = 6

        const val PROFIT_RATE_MSG1 = "총 수익률은 "
        const val PROFIT_RATE_MSG2 = "%입니다."
    }
}