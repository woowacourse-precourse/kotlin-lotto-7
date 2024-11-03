package lotto.model

import lotto.constant.LottoRank

class WinningResult(val result: HashMap<LottoRank, Int>) {


    companion object {
        fun convertToResult(ranks: List<LottoRank>): WinningResult {
            val result = LottoRank.entries.map { rank -> Pair(rank, ranks.count { it == rank }) }
            return WinningResult(result.toMap() as HashMap<LottoRank, Int>)
        }
    }
}