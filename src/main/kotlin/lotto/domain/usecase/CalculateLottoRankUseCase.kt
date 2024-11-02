package lotto.domain.usecase

import lotto.domain.entity.Lotto
import lotto.common.LottoRank
import lotto.domain.entity.WinningNumbers

class CalculateLottoRankUseCase {
    fun execute(lotto: Lotto, winningNumbers: WinningNumbers): LottoRank {
        val matchCount = lotto.getNumbers().count { number ->
            winningNumbers.getNumbers().contains(number)
        }
        return when (matchCount) {
            6 -> LottoRank.FIRST
            5 -> if (lotto.getNumbers().contains(winningNumbers.bonusNumber)) LottoRank.SECOND else LottoRank.FOURTH
            4 -> LottoRank.THIRD
            3 -> LottoRank.FIFTH
            else -> LottoRank.SIXTH
        }
    }
}