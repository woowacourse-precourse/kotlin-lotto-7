package lotto

class LottoResult {
    private val rankCounts = mutableMapOf<LottoRank, Int>().withDefault {0}

    fun addRank(rank: LottoRank) {
        rankCounts[rank] = rankCounts.getValue(rank) + 1
    }
    fun countRank(rank: LottoRank): Int {
        return rankCounts.getValue(rank)
    }
    fun calculateTotalPrize(): Int {
        return rankCounts.entries.sumBy { (rank, count) -> rank.prize * count }
    }
}