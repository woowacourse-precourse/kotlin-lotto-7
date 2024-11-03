package lotto.domain

class GameResult() {
    val winningDetail = mutableMapOf<Rank, Int>(
        Rank.FIRST to 0,
        Rank.SECOND to 0,
        Rank.THIRD to 0,
        Rank.FOURTH to 0,
        Rank.FIFTH to 0,
    )
    private var totalPrizeMoney = 0
    private var gameCount = 0

    fun addWinningDetail(rank: Rank) {
        winningDetail[rank] = (winningDetail[rank] ?: 0) + 1
        totalPrizeMoney += rank.prizeMoney
        gameCount += 1
    }

    fun getEarningRate(): Double {
        return totalPrizeMoney.toDouble() / (gameCount * 1000)
    }
}