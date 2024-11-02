package lotto

class LottoResult {
    val winnersCount: MutableMap<LottoRank, Int> = HashMap()

    init {
        LottoRank.values().forEach { rank ->
            winnersCount[rank] = 0
        }
    }

    /* 당첨자 수 추가 함수 */
    fun addWinners(rank: LottoRank) {
        winnersCount[rank] = (winnersCount[rank] ?: 0) + 1
    }

    /* 당첨자 수 가져오는 함수 */
    fun getWinnersCount(rank: LottoRank): Int {
        return winnersCount[rank] ?: 0
    }

    /* 전체 당첨 결과 출력 함수 */
    fun showResult() {
        println("\n당첨 통계\n---")
        val sortedRanks = listOf(LottoRank.FIFTH, LottoRank.FOUTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST)
        for (rank in sortedRanks) {
            val count = winnersCount[rank] ?: 0
            println("${rank.description} (${String.format("%,d", rank.prize)}원) - ${count}개")
        }
    }

    /* 총 당첨 금액 계산 함수 */
    fun getTotalPrize(): Long {
        var totalPrize = 0L

        for ((rank, count) in winnersCount) {
            totalPrize += rank.prize * count
        }

        return totalPrize
    }
}