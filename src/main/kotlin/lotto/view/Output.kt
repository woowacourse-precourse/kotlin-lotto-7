package lotto.view

import lotto.control.LottoAnalyzer
import lotto.data.LottoWinningCount

class Output {

    fun lottoPurchase(amount: Int) {
        println("\n" + amount + NUMBER_OF_LOTTO)
    }

    fun randomLottoList(randomLottoNumber: List<List<Int>>) {
        "\n" + randomLottoNumber.forEach { list ->
            println(list.sorted())
        }
    }

    fun winningStatistics(amount: Int) {
        println("\n" + WINNING_STATISTICS)
        println(DIVIDER)
        val messages = LottoWinningCount.entries.take(5)
            .joinToString("\n") { result ->
                result.message + result.count.toString() + UNIT
            }
        println(messages)
        println(
            TOTAL_RETURN_INTRO +
            "%,.1f".format(LottoAnalyzer().calculateRateOfReturn(amount)) +
            TOTAL_RETURN_OUTRO
        )
    }

    companion object {
        const val NUMBER_OF_LOTTO = "개를 구매했습니다."
        const val WINNING_STATISTICS = "당첨 통계"
        const val DIVIDER = "---"
        const val UNIT = "개"
        const val TOTAL_RETURN_INTRO = "총 수익률은 "
        const val TOTAL_RETURN_OUTRO = "%입니다."
    }
}