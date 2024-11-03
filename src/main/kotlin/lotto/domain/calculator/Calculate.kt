package lotto.domain.calculator

import lotto.domain.enums.Rank

interface Calculate {
    fun calculateWinningMoney(winning: Map<Rank, Int>): Long
    fun calculateRateOfReturn(winningMoney: Long, purchaseLottoCount: Int): String
}