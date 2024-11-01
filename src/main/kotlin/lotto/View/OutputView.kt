package lotto.View

import lotto.Lotto
import lotto.Model.LottoRank
import lotto.Model.WinningLottoResult
import kotlin.math.round

class OutputView {
    fun printLottos(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { lotto ->
            println(lotto.getNumbers())
        }
        println()
    }

    fun printLottoResult(lottos: List<Lotto>, winningLottoResult: WinningLottoResult) {
        println("당첨 통계")
        val releasedLottoRanks = getReleasedLottoRanks(lottos, winningLottoResult)
        printStatics(releasedLottoRanks)
    }

    private fun getReleasedLottoRanks(lottos: List<Lotto>, winningLottoResult: WinningLottoResult): List<LottoRank> {
        val releasedLottoRanks = mutableListOf<LottoRank>()
        lottos.forEach { lotto: Lotto ->
            releasedLottoRanks.add(lotto.getLottoResult(winningLottoResult))
        }
        return releasedLottoRanks
    }

    private fun printStatics(releasedLottoRanks: List<LottoRank>) {
        val printOrder = listOf(LottoRank.Fifth, LottoRank.Fourth, LottoRank.Third, LottoRank.Second, LottoRank.First)
        var totalWinningPrize = 0L
        printOrder.forEach { currentOrder ->
            printLottoRankResult(releasedLottoRanks, currentOrder)
            totalWinningPrize += printRateOfReturn(releasedLottoRanks, currentOrder)
        }
        val rawTotalRateOfReturn =
            totalWinningPrize.toDouble() / (releasedLottoRanks.size * Lotto.COST).toDouble() * 100
        val totalRateOfReturn = round(rawTotalRateOfReturn * 10) / 10
        println("총 수익률은 ${totalRateOfReturn}%입니다.")
    }

    private fun printLottoRankResult(lottoRanks: List<LottoRank>, lottoRank: LottoRank) {
        val count = getCount(lottoRanks, lottoRank)
        println("${lottoRank.description} - ${count}개")
    }

    private fun printRateOfReturn(lottoRanks: List<LottoRank>, lottoRank: LottoRank): Long {
        val count = getCount(lottoRanks, lottoRank)
        return lottoRank.prize.toLong() * count
    }

    private fun getCount(lottoRanks: List<LottoRank>, lottoRank: LottoRank): Int {
        return lottoRanks.count { it.name == lottoRank.name }
    }
}