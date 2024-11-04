package lotto.view
import lotto.constant.BonusResult
import lotto.constant.LottoRank
import lotto.model.PurchaseMoney
import lotto.model.WinningResult
import java.text.NumberFormat
import java.util.Locale

object OutputView {
    private const val PURCHASE_COUNT_SCRIPT = "%d개를 구매했습니다."
    private const val WINNING_RESULT_SCRIPT = "당첨 통계\n---"
    private const val LOTTO_MATCH_FORMAT = "%s개 일치 (%s원) - %d개"
    private const val LOTTO_MATCH_FORMAT_WITH_BONUS = "%s개 일치, 보너스 볼 일치 (%s원) - %d개"
    private const val YIELD_RATE_SCRIPT = "총 수익률은 %.1f%%입니다."


    fun printLottoCount(lottoCount: Int) {
        println(PURCHASE_COUNT_SCRIPT.format(lottoCount))
    }

    fun printLottoNumber(numbers: List<Int>) {
        println(numbers)
    }

    fun printWinningResult(winningResult: WinningResult) {
        println(WINNING_RESULT_SCRIPT)
        winningResult.result.map { (rank, count) ->
            if (rank == LottoRank.MISS) return@map
            else if (rank.bonusResult == BonusResult.BONUS_MISMATCH) {
                println(LOTTO_MATCH_FORMAT.format(rank.matchCount, formatNumber(rank.prizeMoney), count))
            } else println(LOTTO_MATCH_FORMAT_WITH_BONUS.format(rank.matchCount, formatNumber(rank.prizeMoney),count))
        }
    }

    fun printYieldRate(purchaseMoney: PurchaseMoney, winningResult: WinningResult) {
        println(YIELD_RATE_SCRIPT.format(winningResult.getYieldRate(purchaseMoney)))
    }

    private fun formatNumber(number: Int): String {
        val numberFormat = NumberFormat.getNumberInstance(Locale.US)
        return numberFormat.format(number)
    }
}