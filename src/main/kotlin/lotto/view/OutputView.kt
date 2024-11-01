package lotto.view

import lotto.model.Lotto
import lotto.model.LottoResult

class OutputView {
    fun showLottoQuantity(lottoQuantity: Int) {
        println("\n${lottoQuantity}개를 구매했습니다.")
    }

    fun showLottoNumbers(lotteries: List<Lotto>) {
        for (lotto in lotteries) {
            val lottoNumber = lotto.getLottoNumber()
            println(lottoNumber)
        }
    }

    fun showMatchingLottoAmount(lottoResults: List<LottoResult>) {
        println("당첨 통계")
        println("---")
        lottoResults.reversed().forEach { lottoResult ->
            when (lottoResult.rank) {
                5 -> println("3개 일치 (5,000원) - ${lottoResult.count}개")
                4 -> println("4개 일치 (50,000원) - ${lottoResult.count}개")
                3 -> println("5개 일치 (1,500,000원) - ${lottoResult.count}개")
                2 -> println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${lottoResult.count}개")
                1 -> println("6개 일치 (2,000,000,000원) - ${lottoResult.count}개")
            }
        }
    }

    fun showYield(yield: String) {
        println("총 수익률은 ${yield}%입니다.")
    }
}