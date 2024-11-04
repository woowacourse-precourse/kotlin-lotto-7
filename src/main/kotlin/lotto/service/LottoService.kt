package lotto.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.Constants
import lotto.constants.Constants.LOTTO_SIZE
import lotto.constants.Constants.MAX_NUMBER
import lotto.constants.Constants.MIN_NUMBER
import lotto.model.Lotto
import lotto.model.Rank

class LottoService {
    fun generateLottoList(count: Int): List<Lotto> {
        val lottoList = List(count) {
            val newNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE)
            Lotto(newNumbers)
        }

        return lottoList
    }

    fun getRankingTable(
        lottoList: List<Lotto>,
        winningNumbers: List<Int>,
        bonusNumbers: Int,
    ): Map<Rank, Int> {
        val rankingTable = HashMap<Rank, Int>()

        lottoList.forEach { lotto ->
            val lottoNumbers = lotto.getNumbers()
            val matchCount = getMatchCount(lottoNumbers, winningNumbers)

            when(matchCount) {
                Constants.MATCH_COUNT_FIRST -> rankingTable.getOrDefault(Rank.FIRST, 0) + 1
                Constants.MATCH_COUNT_SECOND -> {
                    if(hasBonusNumber(lottoNumbers, bonusNumbers)) rankingTable.getOrDefault(Rank.SECOND, 0) + 1
                    else rankingTable.getOrDefault(Rank.THIRD, 0) + 1
                }
                Constants.MATCH_COUNT_FOURTH -> rankingTable.getOrDefault(Rank.FOURTH, 0) + 1
                Constants.MATCH_COUNT_FIFTH -> rankingTable.getOrDefault(Rank.FIFTH, 0) + 1
            }
        }

        return rankingTable
    }

    private fun getMatchCount(lottoNumbers: List<Int>, winningNumbers: List<Int>): Int {
        var cnt = 0
        var idx1 = 0
        var idx2 = 0

        while(idx1 < lottoNumbers.size && idx2 < winningNumbers.size) {
            when {
                lottoNumbers[idx1] < winningNumbers[idx2] -> idx1++
                lottoNumbers[idx1] < winningNumbers[idx2] -> idx2++
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

}