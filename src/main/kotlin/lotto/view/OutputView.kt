package lotto.view

import lotto.Lotto
import lotto.domain.Rank

class OutputView {
    fun printPurchaseResult(lottos: List<Lotto>) {
        println("\n${lottos.size}개를 구매했습니다.")
        lottos.forEach { lotto ->
            println(formatLottoNumbers(lotto.getSortedNumbers()))
        }
        println()
    }

    fun printWinningStatistics(
        results: Map<Rank, Int>,
        profitRate: Double,
    ) {
        println("당첨 통계")
        println("---")
        Rank.entries
            .filter { it != Rank.NONE }
            .forEach { rank ->
                val count = results.getOrDefault(rank, 0)
                println("${rank.matchCount}개 일치${getMatchDescription(rank)} (${formatMoney(rank.prize)}원) - ${count}개")
            }
        println("총 수익률은 ${String.format("%.1f", profitRate)}%입니다.")
    }

    private fun formatLottoNumbers(numbers: List<Int>): String =
        numbers.joinToString(", ", "[", "]") {
            it.toString() // padStart 제거
        }

    private fun formatMoney(amount: Int): String = amount.toString().replace(Regex("\\B(?=(\\d{3})+(?!\\d))"), ",")

    private fun getMatchDescription(rank: Rank): String = if (rank == Rank.SECOND) ", 보너스 볼 일치" else ""
}
