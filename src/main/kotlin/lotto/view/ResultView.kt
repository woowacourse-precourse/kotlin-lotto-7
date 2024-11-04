package lotto.view

import lotto.model.Lotto
import lotto.model.LottoResult
import lotto.model.Prize
import java.text.NumberFormat
import java.util.Locale

class ResultView {

    fun displayPurchasedLotto(lottoCount: Int, lottos: List<Lotto>) {
        println("${lottoCount}개를 구매했습니다.")

        lottos.forEach { lotto ->
            println(lotto.getNumbers())
        }
        println()
    }

    fun displayResult(lottoResult: LottoResult) {
        displayTitle()
        displayPrizes(lottoResult)
        displayProfitRate(lottoResult)
    }

    private fun displayTitle() {
        println("당첨 통계")
        println("---")
    }

    private fun displayPrizes(lottoResult: LottoResult) {
        Prize.entries
            .filter { it != Prize.NONE }
            .sortedWith(compareBy({ it.matchCount }, { it.bonusMatch }))
            .forEach { prize ->
                val count = lottoResult.prizeCounts.getOrDefault(prize, 0)
                val bonusText = if (prize.bonusMatch) ", 보너스 볼 일치" else ""
                val formattedPrizeMoney =
                    NumberFormat.getNumberInstance(Locale.KOREA).format(prize.prizeMoney)

                println("${prize.matchCount}개 일치${bonusText} (${formattedPrizeMoney}원) - ${count}개")
            }
    }

    private fun displayProfitRate(lottoResult: LottoResult) {
        println("총 수익률은 ${lottoResult.profitRate}%입니다.")
    }
}