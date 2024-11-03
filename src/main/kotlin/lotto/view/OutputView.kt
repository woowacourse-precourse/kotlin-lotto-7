package lotto.view

import lotto.constant.OutputMessage
import lotto.model.LottoResult

class OutputView {
    fun displayLotto(lotto: List<List<Int>>) {
        OutputMessage.PURCHASE_LOTTO_COUNT.display(lotto.size)
        lotto.forEach {
            println(it)
        }
        println()
    }

    fun displayResult() {
        OutputMessage.RESULT_TITLE.display()
        OutputMessage.FIFTH.display(LottoResult.fifth)
        OutputMessage.FOURTH.display(LottoResult.fourth)
        OutputMessage.THIRD.display(LottoResult.third)
        OutputMessage.SECOND.display(LottoResult.second)
        OutputMessage.FIRST.display(LottoResult.first)
        OutputMessage.PRICE_RATIO.display(LottoResult.priceRatio)
    }
}