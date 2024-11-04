package view

import lotto.model.lotto.Lotto
import lotto.model.lotto.Prize

class OutputView {
    fun printPurchaseLottoNumbers(lottoNumbers: List<Lotto>) {
        println()
        println("${lottoNumbers.size}개를 구매했습니다.")
        lottoNumbers.forEach { println(it.getNumbers()) }
    }

    fun printProfitStatic(results: Map<Prize, Int>, profitRate: String) {
        println()
        println("당첨 통계")
        println("---")
        results.forEach { (prize, count) ->
            println("${prize.description} - ${count}개")
        }
        println("총 수익률은 ${profitRate}입니다.")
    }
}