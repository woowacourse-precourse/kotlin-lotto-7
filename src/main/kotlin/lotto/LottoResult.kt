package lotto

class LottoResult(
    private val lottoList: List<Lotto>,
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int,
) {
    private val lottoMatcher = LottoNumberMatcher()

    private fun getLottoRankList(): List<LottoRank> {
        val lottoRankList = mutableListOf<LottoRank>()
        lottoList.forEach { lotto ->
            val winningCount = lottoMatcher.matchWithWinningNumbers(lotto, winningNumbers)
            val hasBonusNumber = hasBonusNumber(winningCount, lotto)
            if (hasBonusNumber) {
                lottoRankList.add(LottoRank.FIVE_AND_BONUS_MATCHES)
            }
            val winningLottoRank = winningCount.toLottoRank()
            lottoRankList.add(winningLottoRank)
        }
        return lottoRankList
    }

    private fun hasBonusNumber(
        winningCount: Int,
        lotto: Lotto,
    ): Boolean {
        if (winningCount == FIVE_MATCHES) {
            val hasBonusNumber = lottoMatcher.matchWithBonusNumber(lotto, bonusNumber)
            return hasBonusNumber
        }
        return false
    }

    companion object {
        private const val FIVE_MATCHES = 5
    }
}