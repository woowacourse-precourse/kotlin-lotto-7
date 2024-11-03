package control

import data.LottoMatchingCount
import util.SettingValue
import view.Output

class LottoAnalyzer {

    fun analyze(purchasedLottos: List<List<Int>>, winningNumber: List<Int>, bonusNumber: Int) {
        purchasedLottos.forEach { game ->
            analyzeWinningCount(winningNumber, game, bonusNumber)
        }
        Output().winningStatistics(purchasedLottos.size * SettingValue.LOTTO_PRICE)
    }

    private fun analyzeWinningCount(randomLotto: List<Int>, winningNumber: List<Int>, bonusNumber: Int): Any {
        val matchCount = checkWinning(randomLotto, winningNumber)
        if (matchCount == 6) return LottoMatchingCount.FIRST.count++
        if (matchCount == 5 && checkBonus(randomLotto, bonusNumber)) return LottoMatchingCount.SECOND.count++
        if (matchCount == 5) return LottoMatchingCount.THIRD.count++
        if (matchCount == 4) return LottoMatchingCount.FOURTH.count++
        if (matchCount == 3) return LottoMatchingCount.FIFTH.count++
        return LottoMatchingCount.NONE.count++
    }

    private fun checkWinning(randomLotto: List<Int>, winningNumber: List<Int>): Int {
        return winningNumber.intersect(randomLotto.toSet()).size
    }

    private fun checkBonus(randomLotto: List<Int>, bonusNumber: Int): Boolean {
        return bonusNumber in randomLotto
    }

    fun calculateRateOfReturn(amount: Int): Double {
        return (LottoMatchingCount.entries.sumOf { it.count * it.prize } / amount) * 100
    }
}
