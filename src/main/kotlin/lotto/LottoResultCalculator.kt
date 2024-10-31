package lotto

class LottoResultCalculator {

    fun calculateResults(
        purchasedLottos: List<Lotto>,
        winningNumbers: List<Int>,
        bonusNumber: Int
    ): Map<LottoMatchType, Int> {
        val results = mutableMapOf<LottoMatchType, Int>()

        purchasedLottos.forEach { lotto ->
            val matchType = getMatchTypeForLotto(lotto, winningNumbers, bonusNumber)
            if (matchType != null) {
                results[matchType] = results.getOrDefault(matchType, 0) + 1
            }
        }
        return results
    }

    private fun getMatchTypeForLotto(lotto: Lotto, winningNumbers: List<Int>, bonusNumber: Int): LottoMatchType? {
        val matchingNumberCount = lotto.getMatchingNumberCount(winningNumbers)
        val containsBonusNumber = lotto.containsBonusNumber(bonusNumber)
        return LottoMatchType.getMatchType(matchingNumberCount, containsBonusNumber)
    }

    fun calculateProfitRate(results: Map<LottoMatchType, Int>, purchaseAmount: Int): Double {
        val totalReward = results.entries.sumOf { (matchType, count) ->
            matchType.reward.replace(",", "").toInt() * count
        }
        return (totalReward / purchaseAmount.toDouble()) * 100
    }
}

// Lotto 클래스에 확장 함수 추가
fun Lotto.getMatchingNumberCount(winningNumbers: List<Int>): Int {
    return this.getNumbers().count { it in winningNumbers }
}

fun Lotto.containsBonusNumber(bonusNumber: Int): Boolean {
    return bonusNumber in this.getNumbers()
}