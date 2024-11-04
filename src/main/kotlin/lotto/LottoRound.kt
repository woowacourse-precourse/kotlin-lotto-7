package lotto
class LottoRound(private val lottos: List<Lotto>, private val numbers: List<Int>, private val bonusNumber: Int) {

    fun getRankCount(): MutableMap<RANK, Int> {
        val rankCount = mutableMapOf(
            RANK.OTHERS to 0,
            RANK.FIFTH to 0,
            RANK.FOURTH to 0,
            RANK.THIRD to 0,
            RANK.SECOND to 0,
            RANK.FIRST to 0
        )

        lottos.forEach { lotto ->
            val rank = lotto.getRank(numbers, bonusNumber)
            rankCount[rank] = rankCount[rank]!! + 1
        }

        return rankCount
    }

    private fun getTotalPrize(rankCount: MutableMap<RANK, Int>): Int {
        var totalPrize = 0
        rankCount.forEach {
            totalPrize += PRIZE[it.key]!!.times((it.value))
        }
        return totalPrize
    }

    fun getRate(amount: Int): Double {
        val rankCount = getRankCount()
        val totalPrize = getTotalPrize(rankCount)

        return ((totalPrize).toDouble() / amount.toDouble()) * 100
    }

}