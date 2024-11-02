package lotto

import lotto.util.LottoConstants

class LottoResult(
    private val lottoList: List<Lotto>,
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int,
) {
    private val lottoMatcher = LottoNumberMatcher()

    fun getResult(): LottoResultDetail {
        val lottoRankList = getLottoRankList()
        val rateOfReturn = getRateOfReturn(lottoRankList)
        val lottoResultDetail = LottoResultDetail(lottoRankList, rateOfReturn)
        return lottoResultDetail
    }

    private fun getLottoRankList(): List<LottoRank> {
        val lottoRankList = mutableListOf<LottoRank>()
        lottoList.forEach { lotto ->
            val winningCount = lottoMatcher.matchWithWinningNumbers(lotto, winningNumbers)
            val hasBonusNumber = hasBonusNumber(winningCount, lotto)
            val lottoLank = getLottoLank(winningCount, hasBonusNumber)
            lottoRankList.add(lottoLank)
        }
        return lottoRankList
    }

    private fun getLottoLank(
        winningCount: Int,
        hasBonusNumber: Boolean,
    ): LottoRank {
        if (hasBonusNumber) {
            return LottoRank.FIVE_AND_BONUS_MATCHES
        }
        val winningLottoRank = winningCount.toLottoRank()
        return winningLottoRank
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

    // 최종 수익률: (최종 수익 / 구입 금액) * 100
    private fun getRateOfReturn(lottoRankList: List<LottoRank>): Double {
        val purchasePrice = lottoList.size * LottoConstants.PRICE
        val finalProfit = lottoRankList.sumOf { it.price }
        val rateOfReturn =
            ((finalProfit.toDouble() / purchasePrice) * PERCENTAGE_MULTIPLIER).round(2)
        return rateOfReturn
    }

    companion object {
        private const val FIVE_MATCHES = 5
        private const val PERCENTAGE_MULTIPLIER = 100
        private fun Double.round(decimals: Int): Double = "%.${decimals}f".format(this).toDouble()
    }
}