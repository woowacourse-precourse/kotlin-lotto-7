package control

import data.LottoWinningCount
import util.SettingValue
import view.Output

class LottoAnalyzer {

    fun analyze(
        randomLotto: List<List<Int>>,
        winningNumber: List<Int>,
        bonusNumber: Int
    ) {
        randomLotto.forEach { game ->
            winningCountUpdate(winningNumber, game, bonusNumber)
        }
        Output().winningStatistics(randomLotto.size * SettingValue.LOTTO_PRICE)
    }

    // 올바른 수익률 계산은 ((LottoMatchingCount.entries.sumOf { it.count * it.prize } - amount) / amount) * 100 이다
    fun calculateRateOfReturn(amount: Int): Double {
        return (LottoWinningCount.entries.sumOf { it.count * it.prize } / amount) * 100
    }

    private fun winningCountUpdate(
        randomLotto: List<Int>,
        winningNumber: List<Int>,
        bonusNumber: Int
    ): Any {
        val matchCount = checkWinning(randomLotto, winningNumber)
        if (matchCount == 6) return LottoWinningCount.FIRST.count++
        if (matchCount == 5 && checkBonus(randomLotto, bonusNumber)) {
            return LottoWinningCount.SECOND.count++
        }
        if (matchCount == 5) return LottoWinningCount.THIRD.count++
        if (matchCount == 4) return LottoWinningCount.FOURTH.count++
        if (matchCount == 3) return LottoWinningCount.FIFTH.count++
        return LottoWinningCount.NONE.count++
    }

    private fun checkWinning(randomLotto: List<Int>, winningNumber: List<Int>): Int {
        return winningNumber.intersect(randomLotto.toSet()).size
    }

    private fun checkBonus(randomLotto: List<Int>, bonusNumber: Int): Boolean {
        return bonusNumber in randomLotto
    }


//    fun confirmRateOfReturn(amount: Int) {
//
//        )
//    }
}