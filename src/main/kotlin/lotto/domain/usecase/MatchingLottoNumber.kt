package lotto.domain.usecase

import lotto.domain.model.BonusNumber
import lotto.domain.model.Lotto
import lotto.domain.model.Prize

class MatchingLottoNumber(
    private val winningLotto: Lotto,
    private val bonusNumber: BonusNumber,
    private val quickPickLottoTickets: List<Lotto>,
) {
    fun getMatchResult(): List<Prize> {
        val prizes: MutableList<Prize> = mutableListOf()
        quickPickLottoTickets.forEach { quickPicklotto ->
            val matchedNumbers: Int = quickPicklotto.lottoNumbers.intersect(winningLotto.lottoNumbers).size
            val hasBonusNumber: Boolean = quickPicklotto.lottoNumbers.contains(bonusNumber.bonusNumber)
            val prize = Prize.getPrize(matchedNumbers, hasBonusNumber)
            prizes.add(prize)
        }
        return prizes
    }
}