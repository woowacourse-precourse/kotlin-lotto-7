package lotto.view

import lotto.domain.GameResult
import lotto.domain.Lotto
import lotto.domain.Rank
import java.text.DecimalFormat

object OutputView {
    fun printPurchaseAmount(amount: Int) {
        println("$amount" + OUTPUT_PURCHASE_AMOUNT_MESSAGE)
    }

    fun printLottoNumbers(lotto: Lotto) {
        println(lotto.getNumbers().sorted())
    }

    fun printGameResult(gameResult: GameResult) {
        println(OUTPUT_WINNING_STATISTICS_MESSAGE)
        printWinningDetail(gameResult.winningDetail)
        printEarningRate(gameResult.getEarningRate())
    }

    private fun printWinningDetail(winningDetail: Map<Rank, Int>) {
        Rank.entries.reversed().forEach { rank ->
            println(formatRankMessage(rank, winningDetail[rank] ?: 0))
        }
    }

    private fun formatRankMessage(rank: Rank, count: Int): String {
        val prizeMoneyFormat = DecimalFormat("#,###").format(rank.prizeMoney)
        return when (rank) {
            Rank.FIRST, Rank.THIRD, Rank.FOURTH, Rank.FIFTH -> OUTPUT_RANK_MESSAGE.format(
                rank.matchCount,
                prizeMoneyFormat,
                count
            )

            Rank.SECOND -> OUTPUT_RANK_BONUS_MESSAGE.format(
                rank.matchCount,
                prizeMoneyFormat,
                count
            )
        }
    }

    private fun printEarningRate(earningRate: Double) {
        println(OUTPUT_EARNING_RATE_MESSAGE.format(earningRate * 100))
    }

    private const val OUTPUT_PURCHASE_AMOUNT_MESSAGE = "개를 구매했습니다."
    private const val OUTPUT_WINNING_STATISTICS_MESSAGE = "당첨 통계\n---"
    private const val OUTPUT_RANK_MESSAGE = "%d개 일치 (%s원) - %d개"
    private const val OUTPUT_RANK_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개"
    private const val OUTPUT_EARNING_RATE_MESSAGE = "총 수익률은 %.1f%%입니다."
}