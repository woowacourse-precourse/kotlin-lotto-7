package lotto.view

import lotto.model.LottoRank
import lotto.model.LottoTicket
import lotto.utils.Constants.FIFTH
import lotto.utils.Constants.FIRST
import lotto.utils.Constants.FOURTH
import lotto.utils.Constants.SECOND
import lotto.utils.Constants.THIRD
import lotto.utils.OutputConstants.WINNING_STATISTICS

class OutputView {

    fun showPurchasedLottoCount(count: Int, tikets: List<LottoTicket>) {
        println("\n${count}개를 구매했습니다.")
        tikets.forEach { println(it.number) }
    }

    // TODO: 반복해서 코드를 줄일 수 있는 방법이 있지 않을까
    fun showWinningStatistics(matchCount: List<Int>) {
        println(WINNING_STATISTICS)
        println("${LottoRank.FIFTH.matchCount}개 일치 (${LottoRank.FIFTH.reward}) - ${matchCount[FIFTH]}개")
        println("${LottoRank.FOURTH.matchCount}개 일치 (${LottoRank.FOURTH.reward}) - ${matchCount[FOURTH]}개")
        println("${LottoRank.THIRD.matchCount}개 일치 (${LottoRank.THIRD.reward}) - ${matchCount[THIRD]}개")
        println("${LottoRank.SECOND.matchCount}개 일치, 보너스 볼 일치 (${LottoRank.SECOND.reward}) - ${matchCount[SECOND]}개")
        println("${LottoRank.FIRST.matchCount}개 일치 (${LottoRank.FIRST.reward}) - ${matchCount[FIRST]}개")
    }

    fun showTotalReturnRate(totalReturnRate: Float) = println("총 수익률은 $totalReturnRate%입니다.")
}