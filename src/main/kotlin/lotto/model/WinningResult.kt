package lotto.model

import lotto.constant.LottoRank

class WinningResult(val result: HashMap<LottoRank, Int>) {
    fun getYieldRate(purchaseMoney: PurchaseMoney) : Double {
        return getTotalPrizeMoney() / purchaseMoney.money.toDouble() * 100
    }



    private fun getTotalPrizeMoney(): Long =
        result.entries.sumOf { (rank, count) -> rank.prizeMoney.toLong() * count}

    companion object {
        fun convertToResult(ranks: List<LottoRank>): WinningResult {
            val result = LottoRank.entries.map { rank -> Pair(rank, ranks.count { it == rank }) }
            return WinningResult(result.toMap() as HashMap<LottoRank, Int>)
        }
    }
}