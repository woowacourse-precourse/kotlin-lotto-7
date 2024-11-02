package lotto.View

import lotto.Model.Prize
import java.text.NumberFormat
import java.util.Locale

fun printResults(results: Map<Prize, Int>, profitRate: Double) {
    println("당첨 통계\n---")

    val prizesToPrint = Prize.getPrizesToPrint()
    prizesToPrint.forEach { prize ->
        resultPrinter(prize, results[prize] ?: 0)
    }

    println("총 수익률은 %.1f%%입니다.".format(profitRate))
}

private fun resultPrinter(prize: Prize, count: Int) {
    val formatter = NumberFormat.getNumberInstance(Locale.KOREA)
    val formattedPrizeMoney = formatter.format(prize.prizeMoney)
    val bonusText = if (prize.bonus) ", 보너스 볼 일치" else ""
    println("${prize.matchCount}개 일치$bonusText (${formattedPrizeMoney}원) - ${count}개")
}