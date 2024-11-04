package lotto.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.Constants
import lotto.constants.Constants.LOTTO_SIZE
import lotto.constants.Constants.MAX_NUMBER
import lotto.constants.Constants.MIN_NUMBER
import lotto.model.Lotto
import lotto.model.Rank
import lotto.model.Statistics
import kotlin.math.round

class LottoService {
    fun generateLottoList(count: Int): List<Lotto> {
        val lottoList = List(count) {
            val newNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE)
            Lotto(newNumbers)
        }

        return lottoList
    }

    fun getStatistics(
        price: Int,
        lottoList: List<Lotto>,
        winningNumbers: List<Int>,
        bonusNumbers: Int,
    ): Statistics {
        val winningHistory: Map<Rank, Int> = getWinningHistory(lottoList, winningNumbers, bonusNumbers)
        val lottoROI = getLottoROI(price, winningHistory)

        return Statistics(winningHistory, lottoROI)
    }

    private fun getWinningHistory(
        lottoList: List<Lotto>,
        winningNumbers: List<Int>,
        bonusNumbers: Int,
    ): Map<Rank, Int> {
        val rankingTable = LinkedHashMap<Rank, Int>().apply {
            Rank.entries.reversed().forEach {
                this[it] = 0
            }
        }

        lottoList.forEach { lotto ->
            val lottoNumbers = lotto.getNumbers()
            val matchCount = getMatchCount(lottoNumbers, winningNumbers)
            val rank = getRankByMatchCount(matchCount, lottoNumbers, bonusNumbers)
            updateRankingTable(rankingTable, rank)
        }

        return rankingTable
    }

    private fun getRankByMatchCount(
        matchCount: Int,
        lottoNumbers: List<Int>,
        bonusNumber: Int
    ): Rank? {
        return when (matchCount) {
            Constants.MATCH_COUNT_FIRST -> Rank.FIRST
            Constants.MATCH_COUNT_SECOND -> {
                if (hasBonusNumber(lottoNumbers, bonusNumber)) Rank.SECOND else Rank.THIRD
            }
            Constants.MATCH_COUNT_FOURTH -> Rank.FOURTH
            Constants.MATCH_COUNT_FIFTH -> Rank.FIFTH
            else -> null
        }
    }

    private fun updateRankingTable(
        rankingTable: MutableMap<Rank, Int>,
        rank: Rank?
    ) {
        rank?.let {
            rankingTable[it] = rankingTable.getOrDefault(it, 0) + 1
        }
    }

    private fun getMatchCount(lottoNumbers: List<Int>, winningNumbers: List<Int>): Int {
        var cnt = 0
        var idx1 = 0
        var idx2 = 0

        while (idx1 < lottoNumbers.size && idx2 < winningNumbers.size) {
            when {
                lottoNumbers[idx1] < winningNumbers[idx2] -> idx1++
                lottoNumbers[idx1] > winningNumbers[idx2] -> idx2++
                else -> {
                    cnt++
                    idx1++
                    idx2++
                }
            }
        }

        return cnt
    }

    private fun hasBonusNumber(lottoNumbers: List<Int>, bonusNumbers: Int) = bonusNumbers in lottoNumbers

        private fun getLottoROI(price: Int, winningHistory: Map<Rank, Int>): Double {
            val allAmount = calculateAllAmount(winningHistory)
            val roi = allAmount.toDouble() / price * 100

            return round(roi * 10) / 10
        }

    private fun calculateAllAmount(winningHistory: Map<Rank, Int>): Long {
        var sum = 0L

        winningHistory.forEach { (rank, winningCount) ->
            sum += rank.prize * winningCount
        }

        return sum
    }

}