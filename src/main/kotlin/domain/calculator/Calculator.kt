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
        val totalPurchaseAmount = (purchaseLottoCount * 1000).toDouble()
        val rateOfReturn = (winningMoney / totalPurchaseAmount) * 100
        println("총 구매 금액: $totalPurchaseAmount")
        println("총 수익률은 $rateOfReturn%입니다.")
        println("${rateOfReturn.convertRoundAtTwoDecimal()}")
        return rateOfReturn.convertRoundAtTwoDecimal()
    }
}
