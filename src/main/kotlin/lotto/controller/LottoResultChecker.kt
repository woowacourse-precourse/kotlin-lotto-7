package lotto.controller

import lotto.model.Lotto

object LottoResultChecker {

    fun checkWinningStatus(lottos: List<Lotto>, myLotto: Lotto, myBonus: Int): List<Int> {
        val ranking = MutableList(6) { 0 }

        for (lotto in lottos) {
            val (duplicateCount, isBonus) = compareLotto(lotto, myLotto, myBonus)
            when (duplicateCount) {
                3 -> ranking[5]++
                4 -> ranking[4]++
                5 -> if (isBonus) ranking[2]++ else ranking[3]++
                6 -> ranking[1]++
            }
        }
        return ranking
    }

    fun compareLotto(purchasedLotto: Lotto, myLotto: Lotto, myBonus: Int): Pair<Int, Boolean> {
        val sameValueOfLotto = purchasedLotto.getNumbers().intersect(myLotto.getNumbers().toSet())
        val duplicateCount = sameValueOfLotto.size
        val isBonus = myBonus in purchasedLotto.getNumbers()

        return Pair(duplicateCount, isBonus)
    }

    fun calculateProfitRate(money: Int, ranking: List<Int>): Double {
        val profit = RankPerPrice.entries.toTypedArray().sumOf { rank ->
            (ranking.getOrNull(rank.ranked) ?: 0) * rank.price
        }
        val profitRate = profit.toDouble() / money
        return profitRate * 100
    }

    enum class RankPerPrice(val ranked: Int, val price: Int) {
        FIRST(1, 2000000000),
        SECOND(2, 30000000),
        THIRD(3, 1500000),
        FORTH(4, 50000),
        FIFTH(5, 5000);
    }
}