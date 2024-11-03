package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.Constants.MAX_NUMBER
import lotto.utils.Constants.MIN_NUMBER
import lotto.utils.Constants.LOTTO_NUMBER_COUNT
import lotto.utils.Constants.ZERO
import lotto.utils.ErrorConstants
import javax.swing.UIManager.put

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { ErrorConstants.LOTTO_NUMBER_COUNT }
        require(numbers.all { it in MIN_NUMBER..MAX_NUMBER }) { ErrorConstants.LOTTO_NUMBER_RANGE }
        require(numbers.distinct().size == LOTTO_NUMBER_COUNT) { ErrorConstants.LOTTO_NUMBER_DUPLICATE }
    }

    fun calculateLottoResults(lottoTickets: List<LottoTicket>, bonusNumber: Int): Map<LottoRank, Int> {

        val rankCounts = mutableMapOf<LottoRank, Int>()
        LottoRank.entries.forEach { rank -> rankCounts[rank] = 0 }

        lottoTickets.forEach{ ticket ->
            val matchCount = ticket.numbers.count { it in numbers }
            val matchBonus = bonusNumber in ticket.numbers
            val rank = LottoRank.getRank(matchCount, matchBonus)
            rankCounts[rank] = rankCounts.getOrDefault(rank, 0) + 1
        }
        return rankCounts
    }


    fun calculateTotalReturnRate(rankCounts: Map<LottoRank, Int>, pruchaseAmount: Int): Double {
        var totalReturnRate: Double = 0.0

        rankCounts.forEach{ rank, count ->
            totalReturnRate += (rank.reward * count)
        }

        val result = totalReturnRate / pruchaseAmount * 100

        return String.format("%.2f", result).toDouble()
    }
}
