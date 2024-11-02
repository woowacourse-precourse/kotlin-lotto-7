package lotto.domain

class GameResult {
    private val winningDetail = mutableMapOf<Rank, Int>()

    fun addWinningDetail(rank: Rank) {
        winningDetail[rank] = (winningDetail[rank] ?: 0) + 1
    }
}