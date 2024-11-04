package lotto.view

import lotto.model.Lotto
import lotto.model.LottoRank
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
            val rank = LottoRank.entries.find { it.rankNumber == lottoResult.rank }
            rank?.let {
                println("${it.displayName} ${OutputConst.matchedLotteries(lottoResult.count)}")
            }
        }
    }

    fun showYield(yield: String) {
        val totalYieldMessage = OutputConst.getTotalYieldMessage(yield)
        println(totalYieldMessage)
    }
}