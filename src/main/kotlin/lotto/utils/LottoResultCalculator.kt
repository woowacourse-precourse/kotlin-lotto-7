package lotto.utils

import lotto.LottoRank

object LottoResultCalculator {
  fun calculateResults(
    generatedLottos: List<List<Int>>,
    winningNumbers: List<Int>,
    bonusNumber: Int?
  ): Map<LottoRank, Int> {
    val resultMap = mutableMapOf<LottoRank, Int>().withDefault { 0 }

    generatedLottos.forEach { lotto ->
      val matchCount = lotto.count { it in winningNumbers }
      val hasBonus = bonusNumber != null && bonusNumber in lotto

      val rank = LottoRank.fromMatchCountAndBonus(matchCount, hasBonus)
      resultMap[rank] = resultMap.getValue(rank) + 1
    }
    return resultMap
  }

  fun calculateYield(resultMap: Map<LottoRank, Int>, purchaseAmount: Int): Double {
    val totalPrize = resultMap.entries.sumOf { (rank, count) -> rank.prize * count }
    return ((totalPrize.toDouble() / purchaseAmount) * 100).let { Math.round(it * 10) / 10.0 }
  }
}
