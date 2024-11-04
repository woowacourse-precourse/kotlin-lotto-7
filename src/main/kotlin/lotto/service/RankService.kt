package lotto.service

import lotto.model.Lotto
import lotto.model.LottoRank
import lotto.model.PurchaseAmount

object RankService {
    private val rankCount: MutableMap<LottoRank, Int> = mutableMapOf()

    init {
        LottoRank.entries.forEach { rank ->
            rankCount[rank] = 0
        }
    }

    fun calculateLottoRank(winningLotto: Lotto, bonusNumber: Int, lottoTickets: List<Lotto>): Map<LottoRank, Int> {
        lottoTickets.forEach { lottoTicket ->
            val matchingResult = LottoRank.matchingLottoNumber(winningLotto,bonusNumber,lottoTicket)
            val matchingRank = LottoRank.matchingLottoRank(matchingResult)

            incrementMatchingRankCount(matchingRank)
        }
        return rankCount.toMap()
    }

    private fun incrementMatchingRankCount(rank: LottoRank) {
        rankCount[rank] = rankCount.getOrDefault(rank, 0) + 1
    }

    fun calculateTotalReturn(purchaseAmount: PurchaseAmount): Double {
        val winningLottoAmount = rankCount.entries.sumOf {
            it.key.price * it.value
        }
        return (winningLottoAmount.toDouble() / purchaseAmount.getPurchaseAmount()) * 100.0
    }
}