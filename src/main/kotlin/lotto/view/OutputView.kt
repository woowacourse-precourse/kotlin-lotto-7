package lotto.view

import lotto.Constants
import lotto.model.Lotto
import lotto.model.LottoRank

class OutputView {
    fun printLottoAmountMessage(amount: Int) = println("\n${amount}개를 구매했습니다.")

    fun printLottoNumber(lottoTickets: List<Lotto>) {
        lottoTickets.forEach { lotto -> println(lotto.getNumbers()) }
    }

    fun printResult(rankCount: Map<LottoRank, Int>) {
        println(Constants.OUTPUT_RESULT_MESSAGE)
        println(Constants.LINE_SEPARATOR)

        println(Constants.FIFTH_MATCH_PRIZE_MESSAGE.format(rankCount[LottoRank.FIFTH] ?: 0))
        println(Constants.FOURTH_MATCH_PRIZE_MESSAGE.format(rankCount[LottoRank.FOURTH] ?: 0))
        println(Constants.THIRD_MATCH_PRIZE_MESSAGE.format(rankCount[LottoRank.THIRD] ?: 0))
        println(Constants.SECOND_MATCH_PRIZE_MESSAGE.format(rankCount[LottoRank.SECOND] ?: 0))
        println(Constants.FIRST_MATCH_PRIZE_MESSAGE.format(rankCount[LottoRank.FIRST] ?: 0))
    }
}