package lotto.view

import lotto.model.Prize

object OutputView {
    fun printNumbers(buy: Int) {
        return println("${buy}개를 구매했습니다.")
    }

    fun printLottoNumbers(numbers: List<List<Int>>) {
        numbers.forEach { println(it.sorted()) }
    }

    fun printResults(results: Map<Prize, Int>, totalPrize: Int, totalCost: Int) {
        println("당첨 통계")
        println("---")
        Prize.entries.forEach { prize ->
            println("${prize.description} (${prize.moneyString} 원) - ${results[prize] ?: 0}개")
        }
        val profitRate = (totalPrize.toDouble() / totalCost) * 100
        println("총 수익률은 %.1f%%입니다.".format(profitRate))
    }
}