package lotto.view

import lotto.model.LottoPrize
import lotto.model.LottoPrize.SECOND_PRIZE
import java.text.DecimalFormat

class OutputView {

    fun printLottosCount(lottosCount: Int) {
        println()
        println("${lottosCount}개를 구매했습니다.")
    }

    fun printWinningStatisticsTitle() {
        println()
        println("당첨 통계\n---")
    }

    fun printWinningStatistics(prize: LottoPrize, count: Int) {
        var bonusInfo = ""
        if (prize == SECOND_PRIZE) bonusInfo = ", 보너스 볼 일치"

        println("${prize.matchingCount}개 일치$bonusInfo (${THOUSAND_COMMA.format(prize.price)}원) - ${count}개")
    }

    fun printLottoYield(yield: Double) {
        val formattedYield = String.format("%.1f", yield)
        println("총 수익률은 ${formattedYield}%입니다.")
    }

    companion object {
        private val THOUSAND_COMMA = DecimalFormat("#,###")
    }
}

