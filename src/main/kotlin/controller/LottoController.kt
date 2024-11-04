package lotto.controller

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.lotto.Lotto
import lotto.model.lotto.Prize
import lotto.model.lotto.WinningNumbers
import view.InputView
import view.OutputView

class LottoController(private val inputView: InputView, private val outputView: OutputView) {
    fun run(){

    }

    private fun createLottoNumbers(purchasedAmount : Int): List<Lotto>{
        return List(purchasedAmount) { Lotto(Randoms.pickUniqueNumbersInRange(1,45,6)) }
    }

    private fun countMatchingLotto(lotto: Lotto, winningNumbers: WinningNumbers): Prize? {
        val matchCount = lotto.countMatchingNumbers(winningNumbers.winningNumbers)
        val isBonusMatch = lotto.matchBonusNumber(winningNumbers.bonusNumber)

        return when {
            matchCount == 6 -> Prize.SIX_MATCH
            matchCount == 5 && isBonusMatch -> Prize.FIVE_MATCH_BONUS
            matchCount == 5 -> Prize.FIVE_MATCH
            matchCount == 4 -> Prize.FOUR_MATCH
            matchCount == 3 -> Prize.THREE_MATCH
            else -> null
        }
    }

    private fun checkLottoResults(purchasedLotto: List<Lotto>, winningNumbers: WinningNumbers): Map<Prize, Int> {
        val results = mutableMapOf<Prize, Int>().apply {
            Prize.values().forEach { this[it] = 0 }
        }

        purchasedLotto.forEach { lotto ->
            val prize = countMatchingLotto(lotto, winningNumbers)
            prize?.let {
                results[it] = results.getValue(it) + 1
            }
        }

        return results
    }

    private fun calculateProfitRate(results: Map<Prize, Int>, purchaseAmount: Int): String {
        val totalPrize = results.entries.sumOf { it.key.prizeMoney * it.value }
        val profitRate = (totalPrize.toDouble() / purchaseAmount) * 100

        return String.format("%.1f%%", profitRate)
    }
}