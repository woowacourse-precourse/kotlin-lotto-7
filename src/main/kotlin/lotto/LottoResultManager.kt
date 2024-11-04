package lotto

class LottoResultManager(
    private val userLottos: List<Lotto>,
    private val winningLotto: Lotto,
    private val bonusNumber: Int,
    private val buyMoney: Int
) {

    private val rankResults = mutableMapOf(
        Rank.FIFTH to RANK_DEFAULT_COUNT,
        Rank.FOURTH to RANK_DEFAULT_COUNT,
        Rank.THIRD to RANK_DEFAULT_COUNT,
        Rank.SECOND to RANK_DEFAULT_COUNT,
        Rank.FIRST to RANK_DEFAULT_COUNT
    )

    fun calculateRankResults() {
        userLottos.forEach { userLotto ->
            val matchCount = winningLotto.getMatchCount(userLotto)
            val isBonusMatch = userLotto.containsNumber(bonusNumber)
            matchRank(matchCount, isBonusMatch)
        }
    }

    private fun matchRank(matchCount: Int, isBonusMatch: Boolean) {
        when (val rank = Rank.matchRank(matchCount, isBonusMatch)) {
            Rank.NONE -> return
            else -> rankResults[rank] = rankResults.getOrDefault(rank, 0) + 1
        }
    }

    fun showResult() {
        println(RANK_RESULT_MESSAGE)
        rankResults.forEach { rankResult ->
            val (rank, count) = rankResult
            println(formatRankResult(rank, count))
        }
        println(formatProfitResult(calculateProfit(buyMoney)))
    }

    private fun formatRankResult(rank: Rank, count: Int): String {
        return String.format(
            RANK_RESULT_FORMAT,
            rank.matchCount,
            if (rank.hasBonus) HAS_BONUS_MESSAGE else NO_BONUS_MESSAGE,
            rank.money,
            count
        )
    }

    private fun formatProfitResult(profitRate: Double): String {
        return String.format(PROFIT_RESULT_MESSAGE, profitRate)
    }

    private fun calculateProfit(buyMoney: Int): Double {
        val totalMoney = rankResults.map { (rank, count) -> rank.money * count }.sum()
        val profitRate = totalMoney.toDouble() / buyMoney * PROFIT_PERCENT_MULTIPLIER
        return profitRate
    }

    companion object {
        private const val RANK_DEFAULT_COUNT = 0
        private const val RANK_RESULT_MESSAGE = "당첨 통계\n---"
        private const val RANK_RESULT_FORMAT = "%d개 일치%s (%,d원) - %d개"
        private const val HAS_BONUS_MESSAGE = ", 보너스 볼 일치"
        private const val NO_BONUS_MESSAGE = ""
        private const val PROFIT_RESULT_MESSAGE = "총 수익률은 %,.1f%%입니다."
        private const val PROFIT_PERCENT_MULTIPLIER = 100
    }
}