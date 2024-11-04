package lotto.view

import lotto.domain.Lotto
import lotto.domain.Rank
import lotto.domain.WinningStatus
import java.text.DecimalFormat

class OutputView {
    fun printPurchaseAmount(amount: Int) {
        println("\n${amount}개를 구매했습니다.")
    }

    fun printLottoStatus(lottos: List<Lotto>) {
        lottos.forEach { lotto ->
            println(lotto.getNumbers().joinToString(", ", "[", "]"))
        }
    }

    fun printStatistics(result: WinningStatus) {
        val decimal = DecimalFormat("#,###")

        println("\n당첨 통계")
        println("---")
        Rank.entries.filterNot { it == Rank.NONE }
            .sortedBy { it.prize }
            .forEach { rank ->
                println("${rank.description} (${decimal.format(rank.prize)}원) - ${result.rankCount[rank] ?: 0}개")
            }
        println("총 수익률은 ${"%.1f".format(result.profitRate)}%입니다.")
    }
}