package lotto.View

import lotto.Model.Prize

fun printResults(results: Map<Prize, Int>, profitRate: Double) {
    println("당첨 통계")
    println("---")

    val prizesToPrint = Prize.values().filter { it.matchCount >= 3 }

    prizesToPrint.forEach { prize ->
        val bonusText = if (prize.bonus) ", 보너스 볼 일치" else ""
        val count = results[prize] ?: 0
        println("${prize.matchCount}개 일치$bonusText (${prize.prizeMoney}원) - ${count}개")
    }

    println("총 수익률은 %.1f%%입니다.".format(profitRate))
}
