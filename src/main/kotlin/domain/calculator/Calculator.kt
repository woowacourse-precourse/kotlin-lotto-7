package domain.calculator

import domain.enums.Rank
import domain.util.convertRoundAtTwoDecimal

class Calculator : Calculate {
    override fun calculateWinningMoney(winning: Map<Rank, Int>): Long {
        return winning.entries.sumOf { (rank, count) ->
            rank.getReword() * count
        }.toLong()
    }

    override fun calculateRateOfReturn(winningMoney: Long, purchaseLottoCount: Int): String {
        val totalPurchaseAmount = purchaseLottoCount * 1000
        val rateOfReturn = (winningMoney.toDouble() / totalPurchaseAmount) * 100
        return rateOfReturn.convertRoundAtTwoDecimal()
    }
}
