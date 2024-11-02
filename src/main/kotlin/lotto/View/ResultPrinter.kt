package lotto.View

import lotto.Model.Prize
import java.text.NumberFormat
import java.util.Locale

fun printPrizeResult(prize: Prize, count: Int) {
    val formatter = NumberFormat.getNumberInstance(Locale.KOREA)
    val formattedPrizeMoney = formatter.format(prize.prizeMoney)
    val bonusText = if (prize.bonus) ", 보너스 볼 일치" else ""
    println("${prize.matchCount}개 일치$bonusText (${formattedPrizeMoney}원) - ${count}개")
}