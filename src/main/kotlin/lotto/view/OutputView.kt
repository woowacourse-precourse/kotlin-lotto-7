package lotto.view

import lotto.model.Lotto
import lotto.model.LottoResult
import lotto.model.Rank

object OutputView {
    fun printExceptionMessage(message: String?) {
        println(message)
    }

    fun printPurchaseLotto(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { println(it) }
    }

    fun printLottoResult(lottoResults: LottoResult) {
        println("당첨 통계")
        println("---")
        for (rank in Rank.entries) {
            when (rank) {
                Rank.MISS -> continue
                Rank.SECOND -> print("${rank.matchCount}개 일치, 보너스 볼 일치(${rank.winningAmount}원) - ")
                else -> print("${rank.matchCount}개 일치 (${rank.winningAmount}원) - ")
            }
            println("${lottoResults.getCount(rank)}개")
        }
    }

    fun printProfit(profit: Double) {
        println("총 수익률은 ${profit}%입니다.")
    }
}
