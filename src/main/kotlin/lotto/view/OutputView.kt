package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoResult
import lotto.domain.Rank

object OutputView {
    fun printPurchasedLottos(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { lotto ->
            println(lotto.getNumbers())
        }
    }

    fun printResult(result: LottoResult, purchaseAmount: Int) {
        println("당첨 통계")
        println("---")
        val ranks = result.getRanks()
        println("3개 일치 (5,000원) - ${ranks.getOrDefault(Rank.FIFTH, 0)}개")
        println("4개 일치 (50,000원) - ${ranks.getOrDefault(Rank.FOURTH, 0)}개")
        println("5개 일치 (1,500,000원) - ${ranks.getOrDefault(Rank.THIRD, 0)}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${ranks.getOrDefault(Rank.SECOND, 0)}개")
        println("6개 일치 (2,000,000,000원) - ${ranks.getOrDefault(Rank.FIRST, 0)}개")
        val yield = result.calculateYield(purchaseAmount)
        println("총 수익률은 ${"%.1f".format(yield)}%입니다.")
    }
}