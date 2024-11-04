package lotto.domain.usecase

import lotto.domain.entity.Lotto
import lotto.common.LottoRank
import lotto.domain.entity.BonusNumber
import lotto.domain.entity.WinningNumbers

class CalculateLottoRankUseCase {
    fun execute(lotto: Lotto, winningNumbers: WinningNumbers, bonusNumber: BonusNumber): LottoRank {
        val matchCount = lotto.getNumbers().count { number ->
            winningNumbers.getNumbers().contains(number)
        }
        return determineLottoRank(matchCount, lotto, bonusNumber)
    }

    private fun determineLottoRank(matchCount: Int, lotto: Lotto, bonusNumber: BonusNumber): LottoRank {
        when (matchCount) {
            LottoRank.FIRST.matchCount -> return LottoRank.FIRST
            LottoRank.THIRD.matchCount -> return determineRankWithBonus(lotto, bonusNumber)
            LottoRank.FOURTH.matchCount -> return LottoRank.FOURTH
            LottoRank.FIFTH.matchCount -> return LottoRank.FIFTH
        }
        return LottoRank.NON
    }

    private fun determineRankWithBonus(lotto: Lotto, bonusNumber: BonusNumber): LottoRank {
        if (lotto.getNumbers().contains(bonusNumber.number)) return LottoRank.SECOND
        return LottoRank.THIRD
    }
}