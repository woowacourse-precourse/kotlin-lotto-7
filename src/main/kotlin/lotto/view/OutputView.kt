package lotto.view

import lotto.model.LottoRank
import lotto.utils.Constants.FIFTH
import lotto.utils.Constants.FIRST
import lotto.utils.Constants.FOURTH
import lotto.utils.Constants.SECOND
import lotto.utils.Constants.THIRD
import lotto.utils.OutputConstants.WINNING_STATISTICS

/**
 * 뷰는 모델에만 의존해야 하고, 컨트롤러에는 의존하면 안된다.
 * 뷰 내부는 모델 코드만 있을 수 있다.
 * 뷰가 모델로부터 데이터를 받을 때는 사용자마다 다르게 보여주어야 하는데이터에 한해 받는다
 * 모델로부터 데이터를 받을 때는 컨트롤러에서 받아야한다.
 */

class OutputView {

    fun showPurchasedLottoCount(count: Int) = println("\n${count}개를 구매했습니다.")

    // 컨트롤러 -> 모델(LottoGenerator) -> 매개변수 받기 -> 컨트롤러에서 수행
    fun showPurchasedLottoList(count: Int) = println()

    fun showWinningStatisticsMessage() = println(WINNING_STATISTICS)

    fun showWinninfStatistics(matchCount: List<Int>) {
        println("${LottoRank.FIFTH.matchCount}개 일치 (${LottoRank.FIFTH.reward}) - ${matchCount[FIFTH]}개")
        println("${LottoRank.FOURTH.matchCount}개 일치 (${LottoRank.FOURTH.reward}) - ${matchCount[FOURTH]}개")
        println("${LottoRank.THIRD.matchCount}개 일치 (${LottoRank.THIRD.reward}) - ${matchCount[THIRD]}개")
        println("${LottoRank.SECOND.matchCount}개 일치 (${LottoRank.SECOND.reward}) - ${matchCount[SECOND]}개")
        println("${LottoRank.FIRST.matchCount}개 일치 (${LottoRank.FIRST.reward}) - ${matchCount[FIRST]}개")
    }

    fun showTotalReturnRate(totalReturnRate: Float) = println("총 수익률은 $totalReturnRate%입니다.")
}