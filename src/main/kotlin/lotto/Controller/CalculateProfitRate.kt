package lotto.Controller

import lotto.Model.Prize

fun calculateProfitRate(results: Map<Prize, Int>, purchaseAmount: Int): Double {
    val totalPrizeMoney = results.entries.sumOf { (prize, count) -> prize.prizeMoney * count }
    return (totalPrizeMoney / purchaseAmount.toDouble()) * 100
}