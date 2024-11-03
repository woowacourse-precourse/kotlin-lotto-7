package lotto

data class LottoResult(val rankCounts: MutableMap<Rank, Int> = mutableMapOf()) {
    fun addResult(rank: Rank) {
        rankCounts[rank] = rankCounts.getOrDefault(rank, 0) + 1
    }

    fun getResults(): Map<Rank, Int> = rankCounts
}