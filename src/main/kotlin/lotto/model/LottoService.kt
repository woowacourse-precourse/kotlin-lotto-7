package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.Constants
import kotlin.math.round

class LottoService {
    private fun generateLottoNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(
            Constants.LOTTO_NUMBER_MIN,
            Constants.LOTTO_NUMBER_MAX,
            Constants.LOTTO_NUMBERS_SIZE
        )
    }

    fun generateLottoTickets(count: Int): List<Lotto> {
        return List(count) { Lotto(generateLottoNumbers()) }
    }

    fun calculateMatchingNumbers(
        lottoTickets: List<Lotto>,
        winningNumbers: List<Int>,
        bonusNumber: Int
    ): List<LottoRank> {
        return lottoTickets.map { ticket ->
            val matchCount = ticket.getNumbers().count { it in winningNumbers }
            val hasBonus = bonusNumber in ticket.getNumbers()
            determineRank(matchCount, hasBonus)
        }
    }

    private fun determineRank(matchCount: Int, hasBonus: Boolean): LottoRank {
        return when {
            matchCount == Constants.SIX -> LottoRank.FIRST
            matchCount == Constants.FIVE && hasBonus -> LottoRank.SECOND
            matchCount == Constants.FIVE -> LottoRank.THIRD
            matchCount == Constants.FOUR -> LottoRank.FOURTH
            matchCount == Constants.THREE -> LottoRank.FIFTH
            else -> LottoRank.NONE
        }
    }

    fun calculateProfit(rankCount: Map<LottoRank, Int>, lottoAmount: Int): Double {
        val totalPrize = rankCount.entries.sumOf { (rank, count) -> rank.prize * count }
        val profit = totalPrize.toDouble() / lottoAmount
        return round(profit * 10000) / 100
    }
}