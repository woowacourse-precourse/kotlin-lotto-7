package lotto.model

import lotto.utils.Constants.MAX_NUMBER
import lotto.utils.Constants.MIN_NUMBER
import lotto.utils.Constants.LOTTO_NUMBER_COUNT
import lotto.utils.ErrorConstants

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { ErrorConstants.LOTTO_NUMBER_COUNT }
        require(numbers.all { it in MIN_NUMBER..MAX_NUMBER }) { ErrorConstants.LOTTO_NUMBER_RANGE }
        require(numbers.distinct().size == LOTTO_NUMBER_COUNT) { ErrorConstants.LOTTO_NUMBER_DUPLICATE }
    }

    fun calculateLottoResults(lottoTickets: List<LottoTicket>, bonusNumber: Int): Map<LottoRank, Int> {

        val lottoRankCounts = mutableMapOf<LottoRank, Int>()
        LottoRank.entries.forEach { rank -> lottoRankCounts[rank] = 0 }

        lottoTickets.forEach{ ticket ->
            val matchCount = ticket.numbers.count { it in numbers }
            val matchBonus = bonusNumber in ticket.numbers
            val rank = LottoRank.getRank(matchCount, matchBonus)
            lottoRankCounts[rank] = lottoRankCounts.getOrDefault(rank, 0) + 1
        }
        return lottoRankCounts
    }


    fun calculateTotalReturnRate(lottoRankCounts: Map<LottoRank, Int>, pruchaseAmount: Int): Double {
        var totalReturnRate: Double = 0.0

        lottoRankCounts.forEach{ rank, count ->
            totalReturnRate += (rank.reward * count)
        }

        val result = totalReturnRate / pruchaseAmount * 100
        return String.format("%.2f", result).toDouble()
    }
}
