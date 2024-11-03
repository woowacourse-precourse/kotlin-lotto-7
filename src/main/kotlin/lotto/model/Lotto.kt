package lotto.model

import lotto.utils.Constants.INITIAL_DOUBLE_VALUE
import lotto.utils.Constants.MAX_NUMBER
import lotto.utils.Constants.MIN_NUMBER
import lotto.utils.Constants.LOTTO_NUMBER_COUNT
import lotto.utils.Constants.ONE
import lotto.utils.Constants.PERCENTAGE_MULTIPLIER
import lotto.utils.Constants.ZERO
import lotto.utils.ErrorConstants

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { ErrorConstants.LOTTO_NUMBER_COUNT }
        require(numbers.all { it in MIN_NUMBER..MAX_NUMBER }) { ErrorConstants.LOTTO_NUMBER_RANGE }
        require(numbers.distinct().size == LOTTO_NUMBER_COUNT) { ErrorConstants.LOTTO_NUMBER_DUPLICATE }
    }

    fun calculateLottoResults(lottoTickets: List<LottoTicket>, bonusNumber: Int): Map<LottoRank, Int> {

        val lottoRankCounts = mutableMapOf<LottoRank, Int>()
        LottoRank.entries.forEach { rank -> lottoRankCounts[rank] = ZERO }

        lottoTickets.forEach{ ticket ->
            val matchCount = ticket.numbers.count { it in numbers }
            val matchBonus = bonusNumber in ticket.numbers
            val rank = LottoRank.getRank(matchCount, matchBonus)
            lottoRankCounts[rank] = lottoRankCounts.getOrDefault(rank, ZERO) + ONE
        }
        return lottoRankCounts
    }


    fun calculateTotalReturnRate(lottoRankCounts: Map<LottoRank, Int>, pruchaseAmount: Int): Double {
        var totalReturnRate: Double = INITIAL_DOUBLE_VALUE

        lottoRankCounts.forEach{ rank, count ->
            totalReturnRate += (rank.reward * count)
        }

        val result = totalReturnRate / pruchaseAmount * PERCENTAGE_MULTIPLIER
        return String.format("%.2f", result).toDouble()
    }
}
