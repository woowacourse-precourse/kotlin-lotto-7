package domain.calculator

import domain.enums.Rank

interface Calculate {
    fun calculateWinningMoney(winning: Map<Rank, Int>): Long
    fun calculateRateOfReturn(winningMoney: Long, purchaseLottoCount: Int): String
}