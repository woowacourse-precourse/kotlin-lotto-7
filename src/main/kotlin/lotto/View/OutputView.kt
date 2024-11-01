package lotto.View

import lotto.Lotto
import lotto.Model.LottoRank

class OutputView {
    fun printLottos(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { lotto ->
            println(lotto.getNumbers())
        }
        println()
    }

    fun printLottoResult(lottos: List<Lotto>, winningLotto: Lotto, bonusNumber: Int) {
        println("당첨 통계")
        val lottoRanks = mutableListOf<LottoRank>()
        lottos.forEach { lotto: Lotto ->
            lottoRanks.add(lotto.getLottoResult(winningLotto, bonusNumber))
        }
        val printOrder = listOf(LottoRank.Fifth, LottoRank.Fourth, LottoRank.Third, LottoRank.Second, LottoRank.First)
        printOrder.forEach { currentOrder ->
            printLottoRankResult(lottoRanks, currentOrder)
        }
    }

    private fun printLottoRankResult(lottoRanks: List<LottoRank>, lottoRank: LottoRank) {
        val count = getCount(lottoRanks, lottoRank)
        println("${lottoRank.description} - ${count}개")
    }

    private fun getCount(lottoRanks: List<LottoRank>, lottoRank: LottoRank): Int {
        return lottoRanks.count { it.name == lottoRank.name }
    }
}