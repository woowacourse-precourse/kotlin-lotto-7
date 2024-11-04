package lotto.view

import lotto.model.Lotto
import lotto.model.LottoResult
import lotto.model.Rank
import java.text.DecimalFormat

object OutputView {
    private val NUMBER_FORMAT = "#,###.0"
    private val DECIMAL_FORMAT = DecimalFormat(NUMBER_FORMAT)

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
                Rank.SECOND -> print("${rank.matchCount}개 일치, 보너스 볼 일치(${DECIMAL_FORMAT.format(rank.winningAmount)}원) - ")
                else -> print("${rank.matchCount}개 일치 (${DECIMAL_FORMAT.format(rank.winningAmount)}원) - ")
            }
            println("${DECIMAL_FORMAT.format(lottoResults.getCount(rank))}개")
        }
    }

    fun printProfit(profit: Double) {
        println("총 수익률은 ${profit}%입니다.")
    }
}
