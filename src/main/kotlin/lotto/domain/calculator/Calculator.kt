package lotto.domain.calculator

import lotto.domain.enums.Rank
import lotto.domain.util.convertRoundAtTwoDecimal

class Calculator : Calculate {
    override fun calculateWinningMoney(winning: Map<Rank, Int>): Long {
        return winning.entries.sumOf { (rank, count) ->
            rank.getReword() * count
        }.toLong()
    }

    override fun calculateRateOfReturn(winningMoney: Long, purchaseLottoCount: Int): String {
        val totalPurchaseAmount = (purchaseLottoCount * 1000).toDouble()
        val rateOfReturn = (winningMoney / totalPurchaseAmount) * 100
        return rateOfReturn.convertRoundAtTwoDecimal()
    }
}
