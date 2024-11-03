package lotto.model

data class LottoResult(val rankCounts: MutableMap<Rank, Int> = mutableMapOf()) {
    fun getRankedTickets(tickets: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Map<Rank, Int> {
        tickets.forEach { ticket ->
            val rank = Rank.from(
                matchCount = ticket.countMatchingNumbers(winningNumbers),
                matchBonus = ticket.containsBonusNumber(bonusNumber)
            )
            addResult(rank)
        }
        return getResults()
    }

    private fun addResult(rank: Rank) {
        rankCounts[rank] = rankCounts.getOrDefault(rank, 0) + 1
    }

    private fun getResults(): Map<Rank, Int> = rankCounts
}