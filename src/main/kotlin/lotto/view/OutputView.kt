package lotto.view

import lotto.model.Random

class OutputView {
    val randomGenerator = Random()
    fun printPurchaseLottoCount(money: Int) {
        val lottoCount = money / 1000
        println("${lottoCount}$PRINT_PURCHASE_LOTTO_COUNT_MESSAGE")
        println()
    }

    fun printPurchaseLotto(lottos: List<List<Int>>) {
        for (lotto in lottos.indices) {
            println(lotto)
        }
    }

    companion object {
        const val PRINT_PURCHASE_LOTTO_COUNT_MESSAGE = "개를 구매했습니다."
    }


}