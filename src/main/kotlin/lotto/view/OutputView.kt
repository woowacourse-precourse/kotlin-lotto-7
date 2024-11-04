package lotto.view

import lotto.Lotto
import lotto.constants.*

object OutputView {
    fun OutputBuyLottoNumber(buyLotto: List<Lotto>) {
        for (lotto in buyLotto) {
            println(lotto)
        }
    }

    fun OutputWinningStatistics(
        matchingNumbersList: MutableList<Int>,
        yield: String
    ) {
        println(OUTPUT_RESULT_OF_WINNING)
        println("3개 일치 (5,000원) - ${matchingNumbersList[0]}개")
        println("4개 일치 (50,000원) - ${matchingNumbersList[1]}개")
        println("5개 일치 (1,500,000원) - ${matchingNumbersList[2]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${matchingNumbersList[3]}개")
        println("6개 일치 (2,000,000,000원) - ${matchingNumbersList[4]}개")
        println("총 수익률은 ${yield}%입니다.")
    }

}