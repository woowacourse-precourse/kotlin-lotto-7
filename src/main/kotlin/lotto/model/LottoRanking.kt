package lotto.model

import lotto.model.LottoStore
import lotto.util.round

class LottoRanking(var countByRanking: MutableMap<LottoResult, Int>, var totalRevenue: Double) {
    companion object {
        fun of(lottoResults: List<LottoResult>): LottoRanking {
            val lottoResultBundle = initializeResultBundle()  // 1. 초기화
            val prize = calculateTotalPrize(lottoResults, lottoResultBundle)  // 2. 등수에 해당하는 count 증가 및 상금 계산
            val totalRevenue = calculateROI(lottoResults.size, prize)  // 3. 수익률 계산 및 반올림
            return LottoRanking(lottoResultBundle, totalRevenue)
        }

        private fun initializeResultBundle(): MutableMap<LottoResult, Int> {
            val lottoResultBundle = mutableMapOf<LottoResult, Int>()
            LottoResult.entries.forEach { result -> lottoResultBundle[result] = 0 }
            return lottoResultBundle
        }

        private fun calculateTotalPrize(
            lottoResults: List<LottoResult>,
            lottoResultBundle: MutableMap<LottoResult, Int>
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


