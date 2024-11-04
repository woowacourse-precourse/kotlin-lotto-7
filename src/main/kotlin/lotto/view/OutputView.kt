package lotto.view

import lotto.Lotto
import lotto.domain.Rank

class OutputView {
    fun printPurchaseResult(lottos: List<Lotto>) {
        lottoPurchase(lottos.size)
        lottos.forEach { lotto ->
            println(formatLottoNumbers(lotto.getSortedNumbers()))
        }
        println()
    }

    fun printWinningStatistics(
        results: Map<Rank, Int>,
        profitRate: Double,
    ) {
        resultStatistics()
        Rank.entries
            .filter { it != Rank.NONE }
            .forEach { rank ->
                val count = results.getOrDefault(rank, 0)
                println(getEarningCount(rank, getMatchDescription(rank), count, formatMoney(rank.prize)))
            }
        totalEarnedMoney(profitRate)
    }

    private fun formatLottoNumbers(numbers: List<Int>): String = numbers.joinToString(DELIMITER, PREFIX, POSTFIX) { it.toString() }

    private fun formatMoney(amount: Int): String = amount.toString().replace(Regex(MONEY_REGEX), DELIMITER_NO_SPACE)

    private fun getMatchDescription(rank: Rank): String = if (rank == Rank.SECOND) BONUS_MATCH else BLANK

    companion object {
        private const val MONEY_REGEX = "\\B(?=(\\d{3})+(?!\\d))"
        private const val DELIMITER_NO_SPACE = ","
        private const val PREFIX = "["
        private const val POSTFIX = "]"
        private const val DELIMITER = ", "
        private const val BLANK = ""
        private const val BONUS_MATCH = ", 보너스 볼 일치"

        fun lottoPurchase(lottos: Int) {
            println("\n${lottos}개를 구매했습니다.")
        }

        fun resultStatistics() {
            println("\n당첨 통계")
            println("---")
        }

        fun totalEarnedMoney(totalPrize: Double) {
            println("총 수익률은 ${String.format("%.1f", totalPrize)}%입니다.")
        }

        fun getEarningCount(
            rank: Rank,
            description: String,
            count: Int,
            formattedMoney: String,
        ): String = "${rank.matchCount}개 일치$description (${formattedMoney}원) - ${count}개"
    }
}
