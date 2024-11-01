package lotto

import lotto.domain.Lotto
import lotto.domain.LottoRank
import lotto.domain.LottoWinningInfo
import lotto.domain.Money
import lotto.dto.LottoStatistics
import kotlin.math.round

class LottoService {
    val lottos: MutableList<Lotto> = mutableListOf()

    fun issueLottos(money: Money) {
        require(money.amount % Lotto.PRICE == 0) { ERROR_DIVISION }

        val count = money.amount / Lotto.PRICE
        repeat(count) {
            lottos.add(Lotto.create())
        }
    }

    fun getLottoStatistics(winningInfo: LottoWinningInfo): LottoStatistics {
        val totalRankCount = getTotalRankResult(winningInfo)
        val roi = getRatOfReturn(totalRankCount.toMap(), winningInfo)

        return LottoStatistics(totalRankCount.toMap(), roi)
    }

    private fun getRatOfReturn(rankCount: Map<LottoRank, Int>, winningInfo: LottoWinningInfo): Double {
        val totalRevenue = calculatorRevenue(rankCount)

        val roi = (totalRevenue / (lottos.size * Lotto.PRICE)) * 100
        return round(roi * 10) / 10
    }

    private fun calculatorRevenue(rankCount: Map<LottoRank, Int>): Double {
        var total = 0.0
        for (key in rankCount.keys) {
            total += key.prize * rankCount[key]!!
        }

        return total
    }

    private fun getTotalRankResult(winningInfo: LottoWinningInfo): MutableMap<LottoRank, Int> {
        val result = mutableMapOf<LottoRank, Int>()
        for (lotto in lottos) {
            val rank = lotto.getLottoRank(winningInfo)
            result[rank] = result.getOrDefault(rank, 0) + 1
        }

        return result
    }

    companion object {
        const val ERROR_DIVISION = "[ERROR] 지불한 비용은 로또 가격(${Lotto.PRICE})으로 나누어 떨어져야 합니다."
    }
}
