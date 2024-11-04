package lotto.model

import lotto.model.LottoStore
import lotto.util.round

class LottoRanking(var countByRanking: MutableMap<LottoResult, Int>, var totalRevenue: Double){
    companion object {
        fun of(lottoResults: List<LottoResult>): LottoRanking {
            val lottoResultBundle = mutableMapOf<LottoResult, Int>()
            var prize = 0.0

            LottoResult.entries.forEach { result -> lottoResultBundle[result] = 0 }

            for (result in lottoResults) {
                lottoResultBundle[result] = (lottoResultBundle[result] ?: 0) + 1
                prize += result.prize
            }

            prize = calculateROI((lottoResults.size * LottoStore.LOTTO_TICKET_PRICE), prize).round(PRECISION)
            return LottoRanking(lottoResultBundle, prize)
        }

        private fun calculateROI(initialInvestment: Int, profit: Double): Double {
            return (profit / initialInvestment) * PERCENT_FACTOR
        }

        private const val PERCENT_FACTOR = 100
        private const val PRECISION = 2
    }
}