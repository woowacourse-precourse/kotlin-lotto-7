package lotto

class LottoWinningResultCalculator {

    fun calculateResults(
        purchasedLottos: List<Lotto>,
        winningNumbers: List<Int>,
        bonusNumber: Int
    ): Map<LottoMatchType, Int> {
        val results = mutableMapOf<LottoMatchType, Int>()

        purchasedLottos.forEach { lotto ->
            processLottoResult(lotto, winningNumbers, bonusNumber, results)
        }
        return results
    }

    fun processLottoResult(
        lotto: Lotto,
        winningNumbers: List<Int>,
        bonusNumber: Int,
        results: MutableMap<LottoMatchType, Int>
    ) {
        val matchType = getMatchTypeForLotto(lotto, winningNumbers, bonusNumber)
        if (matchType != null) {
            results[matchType] = results.getOrDefault(matchType, 0) + 1
        }
    }

    private fun getMatchTypeForLotto(lotto: Lotto, winningNumbers: List<Int>, bonusNumber: Int): LottoMatchType? {
        val matchingNumberCount = lotto.getMatchingNumberCount(winningNumbers)
        val containsBonusNumber = lotto.containsBonusNumber(bonusNumber)
        return LottoMatchType.getMatchType(matchingNumberCount, containsBonusNumber)
    }

}

// Lotto 클래스에 확장 함수 추가
fun Lotto.getMatchingNumberCount(winningNumbers: List<Int>): Int {
    return this.getNumbers().count { it in winningNumbers }
}

fun Lotto.containsBonusNumber(bonusNumber: Int): Boolean {
    return bonusNumber in this.getNumbers()
}