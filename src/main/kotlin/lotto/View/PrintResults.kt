package lotto.View

import lotto.Model.Prize
import java.text.NumberFormat
import java.util.Locale

fun printResults(results: Map<Prize, Int>, profitRate: Double) {
    println("당첨 통계")
    println("---")

    val prizesToPrint = Prize.values()
        .filter { it.matchCount >= 3 }
        .sortedBy { it.matchCount }

    val formatter = NumberFormat.getNumberInstance(Locale.KOREA)

    prizesToPrint.forEach { prize ->
        val bonusText = if (prize.bonus) ", 보너스 볼 일치" else ""
        val count = results[prize] ?: 0
        val formattedPrizeMoney = formatter.format(prize.prizeMoney)
        println("${prize.matchCount}개 일치$bonusText (${formattedPrizeMoney}원) - ${count}개")
    }

    println("총 수익률은 %.1f%%입니다.".format(profitRate))
}
