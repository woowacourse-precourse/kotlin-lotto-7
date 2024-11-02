package lotto.View

import lotto.Controller.getPrizesToPrint
import lotto.Model.Prize

fun printResults(results: Map<Prize, Int>, profitRate: Double) {
    println("당첨 통계\n---")

    val prizesToPrint = getPrizesToPrint()
    prizesToPrint.forEach { prize ->
        printPrizeResult(prize, results[prize] ?: 0)
    }

    println("총 수익률은 %.1f%%입니다.".format(profitRate))
}