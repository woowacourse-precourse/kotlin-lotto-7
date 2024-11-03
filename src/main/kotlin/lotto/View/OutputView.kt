package lotto.View

import lotto.Lotto
import lotto.Model.LottoRank
import lotto.Model.WinningLottoResult
import kotlin.math.round

class OutputView(private val releasedLottos: List<Lotto>) {
    fun printLottos() {
        println("${releasedLottos.size}개를 구매했습니다.")
        releasedLottos.forEach { lotto ->
            println(lotto.getNumbers())
        }
        println()
    }

    fun printLottoResults(winningLottoResult: WinningLottoResult) {
        println("당첨 통계")
        val lottoRankResults = getLottoRankResults(winningLottoResult)
        printStatics(lottoRankResults)
    }

    private fun getLottoRankResults(winningLottoResult: WinningLottoResult): List<LottoRank> {
        val lottoRankResults = mutableListOf<LottoRank>()
        releasedLottos.forEach { lotto: Lotto ->
            lottoRankResults.add(lotto.getLottoResult(winningLottoResult))
        }
        return lottoRankResults
    }

    private fun printStatics(lottoRankResult: List<LottoRank>) {
        val printOrder = listOf(LottoRank.Fifth, LottoRank.Fourth, LottoRank.Third, LottoRank.Second, LottoRank.First)
        var totalWinningPrize = 0L
        printOrder.forEach { currentOrder ->
            printEachLottoRankResult(lottoRankResult, currentOrder)
            totalWinningPrize += printRateOfReturn(lottoRankResult, currentOrder)
        }
        val totalRateOfReturn = getTotalRateOfReturn(totalWinningPrize, lottoRankResult.size)
        val formattedTotalRateOfReturn = formatWithCommas(totalRateOfReturn)
        println("총 수익률은 ${formattedTotalRateOfReturn}%입니다.")
    }

    private fun getTotalRateOfReturn(totalWinningPrize: Long, lottoAmount: Int): Double {
        val rawTotalRateOfReturn = totalWinningPrize.toDouble() / (lottoAmount * Lotto.COST).toDouble() * 100
        val totalRateOfReturn = round(rawTotalRateOfReturn * 10) / 10
        return totalRateOfReturn
    }

    private fun formatWithCommas(totalRateOfReturn: Double): String {
        return "%,.1f".format(totalRateOfReturn)
    }

    private fun printEachLottoRankResult(lottoRankResults: List<LottoRank>, lottoRankToPrint: LottoRank) {
        val count = getCount(lottoRankResults, lottoRankToPrint)
        println("${lottoRankToPrint.description} - ${count}개")
    }

    private fun printRateOfReturn(lottoRankResults: List<LottoRank>, lottoRank: LottoRank): Long {
        val count = getCount(lottoRankResults, lottoRank)
        return lottoRank.prize.toLong() * count
    }

    private fun getCount(lottoRankResults: List<LottoRank>, lottoRank: LottoRank): Int {
        return lottoRankResults.count { it.name == lottoRank.name }
    }
}