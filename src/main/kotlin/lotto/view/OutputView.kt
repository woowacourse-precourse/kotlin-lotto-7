package lotto.view

import lotto.model.LottoRank
import lotto.utils.OutputMessage

object OutputView {


    fun printLottoNumbers(lottoNumbers: List<List<Int>>) {
        println(OutputMessage.PURCHASED_LOTTOS.format(lottoNumbers.size))
        lottoNumbers.forEach { println(it) }
    }

    fun printLottoResult(result: MutableMap<LottoRank, Int>) {
        println(OutputMessage.RESULT_TITLE)
        println(OutputMessage.DIVIDER)
        result.keys.sorted().reversed().forEach { rank ->   // rank가 낮은거 부터
            when (rank) {
                LottoRank.FIRST -> println(OutputMessage.MATCH_COUNT.format(rank.matchCount, rank.prize, result[rank]))
                LottoRank.SECOND -> println(OutputMessage.MATCH_COUNT_WITH_BONUS.format(rank.matchCount, rank.prize, result[rank]))
                LottoRank.THIRD -> println(OutputMessage.MATCH_COUNT.format(rank.matchCount, rank.prize, result[rank]))
                LottoRank.FOURTH -> println(OutputMessage.MATCH_COUNT.format(rank.matchCount, rank.prize, result[rank]))
                LottoRank.FIFTH -> println(OutputMessage.MATCH_COUNT.format(rank.matchCount, rank.prize, result[rank]))
                LottoRank.NONE -> {}
            }
        }
    }

    fun printProfitRate(profitRate: Double) {
        println(OutputMessage.PROFIT_RATE.format(profitRate))
    }
}