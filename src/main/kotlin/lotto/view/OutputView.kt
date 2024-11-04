package lotto.view

import lotto.util.RankType

object OutputView {
    private const val LOTTO_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
    private const val PURCHASE_COUNT_MESSAGE = "개를 구매했습니다."
    private const val WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요."
    private const val BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."
    private const val STATISTICS_MESSAGE = "당첨 통계"
    private const val DIVIDER_MESSAGE = "---"

    private const val RANK_5TH = "3개 일치 (5,000원) - "
    private const val RANK_4TH = "4개 일치 (50,000원) - "
    private const val RANK_3RD = "5개 일치 (1,500,000원) - "
    private const val RANK_2ND = "5개 일치, 보너스 볼 일치 (30,000,000원) - "
    private const val RANK_1ST = "6개 일치 (2,000,000,000원) - "

    private const val INDEX_1ST = 0
    private const val INDEX_2ND = 1
    private const val INDEX_3RD = 2
    private const val INDEX_4TH = 3
    private const val INDEX_5TH = 4

    fun printAmountMessage() {
        println(LOTTO_AMOUNT_MESSAGE)
    }

    fun printPurchaseCountMessage(count: Int) {
        println()
        println("${count}${PURCHASE_COUNT_MESSAGE}")
    }

    fun printTicketMessage(ticket: List<Int>) {
        println(ticket)
    }

    fun printWinningNumberMessage() {
        println()
        println(WINNING_NUMBER_MESSAGE)
    }

    fun printBonusNumberMessage() {
        println()
        println(BONUS_NUMBER_MESSAGE)
    }

    fun printStatistics(rank: Map<RankType, Int>) {
        println()
        println(STATISTICS_MESSAGE)
        println(DIVIDER_MESSAGE)
        println("${RANK_5TH}${rank[RankType.FIFTH] ?: 0}개")
        println("${RANK_4TH}${rank[RankType.FOURTH] ?: 0}개")
        println("${RANK_3RD}${rank[RankType.THIRD] ?: 0}개")
        println("${RANK_2ND}${rank[RankType.SECOND] ?: 0}개")
        println("${RANK_1ST}${rank[RankType.FIRST] ?: 0}개")
    }

    fun printProfitRate(profitRate: String) {
        println("총 수익률은 ${profitRate}%입니다.")
    }
}
