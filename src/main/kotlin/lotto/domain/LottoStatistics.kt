package lotto.domain

class LottoStatistics {

    private val rankCounts = mutableMapOf<Rank, Int>()

    init {
        Rank.entries.forEach { rank ->
            rankCounts[rank] = INITIAL_RANK_COUNT
        }
    }

    fun incrementRankCount(rank: Rank) {
        rankCounts[rank] = rankCounts.getOrDefault(rank, INITIAL_RANK_COUNT) + 1
    }

    fun getRankCount(rank: Rank): Int =
        rankCounts.getOrDefault(rank, INITIAL_RANK_COUNT)

    fun getTotalPrize(): Long =
        rankCounts.entries.sumOf { rank ->
            rank.key.getPrize().toLong() * rank.value
        }

    companion object {
        const val INITIAL_RANK_COUNT = 0
    }
}
