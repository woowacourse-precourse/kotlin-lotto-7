package lotto.View

import lotto.Lotto
import lotto.Model.LottoRank

class OutputView {
    fun printLottos(releasedLottos: List<Lotto>) {
        println("${releasedLottos.size}개를 구매했습니다.")
        releasedLottos.forEach { lotto ->
            println(lotto.getNumbers())
        }
        println()
    }

    fun printLottoResults(lottoRankResults: Map<LottoRank, Int>, totalRateOfReturn: Double) {
        println("당첨 통계")
        println("---")
        val printOrder = listOf(LottoRank.Fifth, LottoRank.Fourth, LottoRank.Third, LottoRank.Second, LottoRank.First)
        printOrder.forEach { currentOrder ->
            printEachLottoRankResult(lottoRankResults, currentOrder)
        }
        val formattedTotalRateOfReturn = formatWithCommas(totalRateOfReturn)
        println("총 수익률은 ${formattedTotalRateOfReturn}%입니다.")
    }

    private fun formatWithCommas(totalRateOfReturn: Double): String {
        return "%,.1f".format(totalRateOfReturn)
    }

    private fun printEachLottoRankResult(lottoRankResults: Map<LottoRank, Int>, lottoRankToPrint: LottoRank) {
        val count = getCount(lottoRankResults, lottoRankToPrint)
        println("${lottoRankToPrint.description} - ${count}개")
    }

    private fun getCount(lottoRankResults: Map<LottoRank, Int>, lottoRankToPrint: LottoRank): Int {
        if (lottoRankResults.keys.contains(lottoRankToPrint)) {
            return lottoRankResults[lottoRankToPrint]!!
        }
        return 0
    }
}