package lotto.domain

class GameResult {
    val winningDetail = mutableMapOf(
        Rank.FIRST to 0,
        Rank.SECOND to 0,
        Rank.THIRD to 0,
        Rank.FOURTH to 0,
        Rank.FIFTH to 0,
    )
    private var totalPrizeMoney = 0
    private var gameCount = 0

    fun addWinningDetail(rank: Rank?) {
        gameCount += 1
        if (rank == null) return
        winningDetail[rank] = (winningDetail[rank] ?: 0) + 1
        totalPrizeMoney += rank.prizeMoney
    }

    fun getEarningRate(): Double {
        return totalPrizeMoney.toDouble() / (gameCount * LOTTO_PRICE)
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}