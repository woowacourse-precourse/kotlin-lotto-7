package lotto.view

import lotto.model.Lotto
import lotto.model.LottoResult
import lotto.util.constant.OutputConst

class OutputView {
    fun showErrorMessage(errorMessages: String) {
        println(errorMessages)
    }

    fun showLottoQuantity(lottoQuantity: Int) {
        val lottoQuantityMessage = OutputConst.getLottoQuantityMessage(lottoQuantity)
        println(lottoQuantityMessage)
    }

    fun showLottoNumbers(lotteries: List<Lotto>) {
        for (lotto in lotteries) {
            val lottoNumber = lotto.getLottoNumber()
            println(lottoNumber)
        }
    }

    fun showMatchingLottoAmount(lottoResults: List<LottoResult>) {
        println(OutputConst.RESULT)
        lottoResults.reversed().forEach { lottoResult ->
            when (lottoResult.rank) {
                5 -> println("${OutputConst.THREE_MATCHED} ${OutputConst.matchedLotteries(lottoResult.count)}")
                4 -> println("${OutputConst.FOUR_MATCHED} ${OutputConst.matchedLotteries(lottoResult.count)}")
                3 -> println("${OutputConst.FIVE_MATCHED} ${OutputConst.matchedLotteries(lottoResult.count)}")
                2 -> println("${OutputConst.FIVE_MATCHED_WITH_BONUS} ${OutputConst.matchedLotteries(lottoResult.count)}")
                1 -> println("${OutputConst.SIX_MATCHED} ${OutputConst.matchedLotteries(lottoResult.count)}")
            }
        }
    }

    fun showYield(yield: String) {
        val totalYieldMessage = OutputConst.getTotalYieldMessage(yield)
        println(totalYieldMessage)
    }
}