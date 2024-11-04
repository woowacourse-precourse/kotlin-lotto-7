package lotto.view

import lotto.domain.Rank

class OutputView {
    fun printPurchaseCountMessage(purchaseCount: Int) =
        println("${NEW_LINE + purchaseCount}개를 구매했습니다.")

    fun printLottoNumber(lotto: List<Int>) = println(lotto)

    fun printStatisticsMessages() =
        println("${NEW_LINE}당첨 통계" + "$NEW_LINE + $DASH_LINE")

    fun printLottoRankResult(rankCountMap: Map<Rank, Int>) {
        println("${MATCH_THREE}개 일치 (${FIFTH_PRIZE_FORMAT}원) - ${rankCountMap[Rank.FIFTH] ?: ZERO}개")
        println("${MATCH_FOUR}개 일치 (${FOURTH_PRIZE_FORMAT}원) - ${rankCountMap[Rank.FOURTH] ?: ZERO}개")
        println("${MATCH_FIVE}개 일치 (${THIRD_PRIZE_FORMAT}원) - ${rankCountMap[Rank.THIRD] ?: ZERO}개")
        println("${MATCH_FIVE}개 일치, 보너스 볼 일치 (${SECOND_PRIZE_FORMAT}원) - ${rankCountMap[Rank.SECOND] ?: ZERO}개")
        println("${MATCH_SIX}개 일치 (${FIRST_PRIZE_FORMAT}원) - ${rankCountMap[Rank.FIRST] ?: ZERO}개")
    }

    fun printProfitRate(revenueRate: Double) {
        val formattedRevenueRate = String.format(PROFIT_RATE_FORMAT, revenueRate)
        println("총 수익률은 ${formattedRevenueRate}%입니다.")
    }

    companion object {
        private const val NEW_LINE = "\n"
        private const val DASH_LINE = "---"
        private const val ZERO = 0

        private const val MATCH_THREE = 3
        private const val MATCH_FOUR = 4
        private const val MATCH_FIVE = 5
        private const val MATCH_SIX = 6

        private const val FIFTH_PRIZE_FORMAT = "5,000"
        private const val FOURTH_PRIZE_FORMAT = "50,000"
        private const val THIRD_PRIZE_FORMAT = "1,500,000"
        private const val SECOND_PRIZE_FORMAT = "30,000,000"
        private const val FIRST_PRIZE_FORMAT = "2,000,000,000"

        private const val PROFIT_RATE_FORMAT = "%.1f"
    }
}
