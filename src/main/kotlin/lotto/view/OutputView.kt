package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoResult
import lotto.domain.Rank
import lotto.util.Constants

object OutputView {
    // 구매한 로또 번호 출력
    fun printPurchasedLottos(lottos: List<Lotto>) {
        println(String.format(Constants.MESSAGE_PURCHASED_LOTTOS, lottos.size))
        lottos.forEach { lotto ->
            println(lotto.getNumbers())
        }
    }

    // 당첨 결과 출력
    fun printResult(result: LottoResult, purchaseAmount: Int) {
        println(Constants.MESSAGE_WINNING_STATISTICS)
        Rank.values()
            .filter { it != Rank.NONE }
            .sortedBy { it.prizeMoney }
            .forEach { rank ->
                printRankResult(rank, result)
            }
        printYield(result, purchaseAmount)
    }

    // 특정 등수의 결과 출력
    private fun printRankResult(rank: Rank, result: LottoResult) {
        val count = result.getRankCounts().getOrDefault(rank, 0)
        val message = when (rank) {
            Rank.SECOND -> "5개 일치, 보너스 볼 일치 (${rank.prizeMoney.toFormattedString()}원) - ${count}개"
            else -> "${rank.matchCount}개 일치 (${rank.prizeMoney.toFormattedString()}원) - ${count}개"
        }
        println(message)
    }

    // 수익률 출력
    private fun printYield(result: LottoResult, purchaseAmount: Int) {
        val yield = result.calculateYield(purchaseAmount)
        println(String.format(Constants.MESSAGE_TOTAL_YIELD, yield))
    }

    // 금액 포맷 설정
    private fun Long.toFormattedString(): String = "%,d".format(this)
}
