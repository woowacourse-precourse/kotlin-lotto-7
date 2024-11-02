package lotto

class LottoStatistic {

    fun confirmWinning(purchasedLottos: List<List<Int>>, winningNumber: List<Int>, bonusNumber: Int) {
        purchasedLottos.forEach { game ->
            analyzeWinningCount(winningNumber, game, bonusNumber)
        }
    }

    private fun analyzeWinningCount(winningNumber: List<Int>, randomLotto: List<Int>, bonusNumber: Int): Any {
        val matchCount = checkWinning(winningNumber, randomLotto)
        if (matchCount == 6) return LottoMatchingCount.FIRST.count++
        if (matchCount == 5 && checkBonus(bonusNumber, randomLotto)) return LottoMatchingCount.SECOND.count++
        if (matchCount == 5) return LottoMatchingCount.THIRD.count++
        if (matchCount == 4) return LottoMatchingCount.FOURTH.count++
        if (matchCount == 3) return LottoMatchingCount.FIFTH.count++
        return LottoMatchingCount.NONE.count++
    }

    private fun checkWinning(winningNumber: List<Int>, randomLotto: List<Int>): Int {
        return winningNumber.intersect(randomLotto.toSet()).size
    }

    private fun checkBonus(bonusNumber: Int, randomLotto: List<Int>): Boolean {
        return bonusNumber in randomLotto
    }

    fun calculateRateOfReturn(amount: Int): Double {
        return (LottoMatchingCount.entries.sumOf { it.count * it.prize } / amount) * 100
    }
}
