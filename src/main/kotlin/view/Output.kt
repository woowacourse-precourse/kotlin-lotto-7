package view

import lotto.LottoMatchingCount
import lotto.LottoStatistic
import util.SettingValue

class Output {

    fun lottoPurchase(amount: Int) {
        println("\n" + amount / SettingValue.LOTTO_PRICE + NUMBER_OF_LOTTO)
    }

    fun randomLottoList(randomLottoNumber: List<List<Int>>) {
        Lotto(randomLottoNumber)
    }

    fun winningStatistics(amount: Int) {
        println("\n" + WINNING_STATISTICS)
        println(DIVIDER)
        LottoMatchingCount.entries.take(5).forEach { result ->
            println(result.message + result.count.toString() + UNIT)
        }
        println(
            TOTAL_RETURN_INTRO
                    + "%,.1f".format(LottoStatistic().calculateRateOfReturn(amount))
                    + TOTAL_RETURN_OUTRO
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