package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.Constants

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
            matchCount == 6 -> LottoRank.FIRST
            matchCount == 5 && hasBonus -> LottoRank.SECOND
            matchCount == 5 -> LottoRank.THIRD
            matchCount == 4 -> LottoRank.FOURTH
            matchCount == 3 -> LottoRank.FIFTH
            else -> LottoRank.NONE
        }
    }
}