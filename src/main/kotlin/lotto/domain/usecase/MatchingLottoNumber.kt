package lotto.domain.usecase

import lotto.domain.model.BonusNumber
import lotto.domain.model.Lotto
import lotto.domain.model.Prize

class MatchingLottoNumber(
    val luckyNumbers: Lotto,
    val bonusNumber: BonusNumber,
    val lottoTickets: List<Lotto>,
) {
    fun getMatchResult(): List<Prize> {
        return lottoTickets.map { lotto ->
            val matchedNumbers: Int = lotto.luckyNumbers.intersect(luckyNumbers.luckyNumbers).size
            val hasBonusNumber: Boolean = lotto.luckyNumbers.contains(bonusNumber.bonusNumber)

            Prize.getPrize(matchedNumbers, hasBonusNumber)
        }
    }
}