package lotto.view

import lotto.model.Lotto
import lotto.model.Random

class OutputView {

    fun printPurchaseLottoCount(count: Int) {
        println("${count}$PRINT_PURCHASE_LOTTO_COUNT_MESSAGE")
    }

    fun printPurchaseLotto(lottos: List<Lotto>) {
        for (lotto in lottos) {
            println(lotto)
        }
        println()
    }

    companion object {
        const val PRINT_PURCHASE_LOTTO_COUNT_MESSAGE = "개를 구매했습니다."
    }


}