package lotto

import lotto.domain.Lotto
import lotto.domain.LottoPurchaseMoney
import lotto.domain.LottoRank
import lotto.domain.LottoWinningInfo
import lotto.dto.LottoStatistics
import kotlin.math.round

class LottoService {
    val lottos: MutableList<Lotto> = mutableListOf()

    fun issueLottos(money: LottoPurchaseMoney) {
        val count = money.amount / Lotto.PRICE
        repeat(count) {
            lottos.add(Lotto.create())
        }
    }

    fun getLottoStatistics(winningInfo: LottoWinningInfo): LottoStatistics {
        val totalRankCount = getTotalRankResult(winningInfo)
        val roi = getReturnOnInvestment(totalRankCount.toMap(), winningInfo)

        return LottoStatistics(totalRankCount.toMap(), roi)
    }

    private fun getReturnOnInvestment(rankCount: Map<LottoRank, Int>, winningInfo: LottoWinningInfo): Double {
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


}
