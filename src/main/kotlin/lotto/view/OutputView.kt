package lotto.view

import lotto.model.Lotto
import lotto.service.LottoService

class OutputView {
    fun printLottos(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { println(it.getNumbers().sorted()) }
    }

    fun printStatistics(statistics: Map<String, Int>, purchaseAmount: Int) {
        println("당첨 통계\n---")
        statistics.forEach { (key, value) -> println("$key - ${value}개") }
        val totalPrize = LottoService().calculateRateOfReturn(statistics)
        val profitRate = (totalPrize / purchaseAmount.toDouble()) * 100
        println("총 수익률은 ${"%.1f".format(profitRate)}%입니다.")
    }
}