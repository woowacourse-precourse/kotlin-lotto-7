package lotto

object LottoResultChecker {
    fun checkWinningStatus(lottos: List<Lotto>, myLotto: Lotto, myBonus: Int)
            : Pair<List<Int>, Int> {
        val winningCounts = MutableList(7) { 0 }
        var bonusWin = 0;

        for (lotto in lottos) {
            val sameValueOfLotto = lotto.getNumbers().intersect(myLotto.getNumbers().toSet())
            val matchingCount = sameValueOfLotto.size
            val containsBonus = myBonus in lotto.getNumbers()

            if(matchingCount>=3)
                winningCounts[matchingCount]++
            if (matchingCount == 5 && containsBonus){
                bonusWin++
                winningCounts[matchingCount]--
            }
        }
        return Pair(winningCounts, bonusWin)
    }

    fun calculateProfitRate(money: Int, winningCounts: List<Int>, bonusWin: Int): Double {
        val profit =
            winningCounts[3] * 5000 + winningCounts[4] * 50000 + winningCounts[5] * 1500000 + winningCounts[6] * 2000000000 + bonusWin * 30000000
        val profitRate = profit.toDouble() / money
        return profitRate * 100
    }
}