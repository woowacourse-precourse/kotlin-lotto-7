package lotto.view

import lotto.model.Lotto
import lotto.model.LottoResult

object OutputView {
    fun printExceptionMessage(message: String?) {
        println(message)
    }

    fun printPurchaseLotto(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { println(it) }
    }

    fun printLottoResult(lottoResults: LottoResult) {

    }

    fun printProfit(profit: Double) {
        println("총 수익률은 ${profit}%입니다.")
    }
}
