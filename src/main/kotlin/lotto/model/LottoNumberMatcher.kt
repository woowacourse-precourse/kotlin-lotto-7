package lotto.model

class LottoNumberMatcher {
    // TODO: 두 개의 리스트가 모두 Set 이라면 intersect 메서드가 더 효율적일 것으로 예상
    fun matchWithWinningNumbers(
        lotto: Lotto,
        winningNumbers: List<Int>,
    ): Int {
        val lottoNumbers = lotto.getNumbers()
        val matchCount = lottoNumbers.count { it in winningNumbers }
        return matchCount
    }

    fun matchWithBonusNumber(
        lotto: Lotto,
        bonusNumber: Int,
    ): Boolean {
        val lottoNumbers = lotto.getNumbers()
        return lottoNumbers.contains(bonusNumber)
    }
}