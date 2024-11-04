package lotto.view

import lotto.Lotto
import lotto.constants.*

object OutputView {
    fun OutputBuyLottoNumber(buyLotto: List<Lotto>) {
        for (lotto in buyLotto) {
            println(lotto)
        }
    }

    fun OutputWinningStatistics() {
        println(OUTPUT_RESULT_OF_WINNING)
    }
}