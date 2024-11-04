package lotto.view

import lotto.model.Lotto
import lotto.model.LottoRank
import java.text.DecimalFormat

class OutputView {
    fun printPurchaseAmountRequest() {
        println(INPUT_PURCHASE_AMOUNT)
    }

    fun printPurchaseQuantity(quantity: Int) {
        println("${quantity}개를 구매했습니다.")
    }

    fun printPurchaseLotto(lottos: List<Lotto>, quantity: Int) {
        println(EMPTY)
        printPurchaseQuantity(quantity)
        lottos.forEach {
            println(it.getLotto())
        }
    }

    fun printWinningLottoRequest() {
        println(EMPTY)
        println(INPUT_WINNING_NUMBERS)
    }

    fun printBonusNumberRequest() {
        println(EMPTY)
        println(INPUT_BONUS_NUMBER)
    }

    fun printMatchingResult(rankCount: Map<LottoRank, Int>) {
        println(EMPTY)
        println(WINNING_LOTTO_STATISTICS)
        println(DIVIDING_LINE)
        rankCount.forEach { rank, count ->
            if (rank.matchingNumbers != 0) {
                println(formatRankMessage(rank.message, rank.price, count))
            }
        }
    }

    private fun formatRankMessage(rankMessage: String, rankPrice: Int, count: Int) = "$rankMessage (${rankPrice}원) - ${count}개"

    fun printTotalRateOfReturn(rateOfReturn: Double) {
        println("총 수익률은 ${rateOfReturn}%입니다.")
    }

    companion object {
        private const val EMPTY = ""
        private const val INPUT_PURCHASE_AMOUNT = "구매금액을 입력해 주세요."
        private const val INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요."
        private const val INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."
        private const val WINNING_LOTTO_STATISTICS = "당첨 통계"
        private const val DIVIDING_LINE = "---"

        private val decimal = DecimalFormat("#,###")
    }
}