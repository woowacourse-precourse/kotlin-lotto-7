package lotto.model

import lotto.model.LottoStore
import lotto.util.round

class LottoRanking(var countByRanking: MutableMap<LottoResult, Int>, var totalRevenue: Double) {
    companion object {
        fun of(lottoResults: List<LottoResult>): LottoRanking {
            val lottoResultBundle = initializeResultBundle()
            val prize = calculateTotalPrize(lottoResults, lottoResultBundle)
            val totalRevenue = calculateROI(lottoResults.size, prize)
            return LottoRanking(lottoResultBundle, totalRevenue)
        }

        private fun initializeResultBundle(): MutableMap<LottoResult, Int> {
            val lottoResultBundle = mutableMapOf<LottoResult, Int>()
            LottoResult.entries.forEach { result -> lottoResultBundle[result] = 0 }
            return lottoResultBundle
        }

        private fun calculateTotalPrize(
            lottoResults: List<LottoResult>, lottoResultBundle: MutableMap<LottoResult, Int>
        ): Double {
            var prize = 0.0
            for (result in lottoResults) {
                lottoResultBundle[result] = (lottoResultBundle[result] ?: 0) + 1
                prize += result.prize
            }
            return prize
        }

        private fun calculateROI(lottoCount: Int, profit: Double): Double {
            val initialInvestment = lottoCount * LottoStore.LOTTO_TICKET_PRICE
            val roi = (profit / initialInvestment) * PERCENT_FACTOR
            return roi.round(PRECISION)
        }

        private const val PERCENT_FACTOR = 100
        private const val PRECISION = 2
    }
}


