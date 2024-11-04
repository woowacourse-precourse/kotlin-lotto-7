package lotto.model

import lotto.util.RankType

class RankCalculator(
    private val winningLotto: Lotto,
    private val bonusNumber: BonusNumber,
    private val lottoMachine: LottoMachine
) {
    fun calculateRank(): Map<RankType, Int> {
        val rankCount = mutableMapOf<RankType, Int>()

        lottoMachine.lottoTickets.forEach { lottoTicket ->
            val matchCount = lottoTicket.count { it in winningLotto }
            val hasBonus = lottoTicket.contains(LottoNumber(bonusNumber.number))
            val rank = RankType.getRankType(matchCount, hasBonus)

            rankCount[rank] = rankCount.getOrDefault(rank, 0) + 1
        }

        return rankCount
    }
}
