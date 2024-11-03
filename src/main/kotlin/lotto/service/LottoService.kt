package lotto.service

import lotto.model.Lotto
import camp.nextstep.edu.missionutils.Randoms
import lotto.Constants

class LottoService {
    fun purchaseLottos(amount: Int): List<Lotto> {
        val lottoCount = amount / Constants.LOTTO_PRICE
        return List(lottoCount) { Lotto(Randoms.pickUniqueNumbersInRange(Constants.MIN_LOTTO_NUMBER, Constants.MAX_LOTTO_NUMBER, Constants.WINNING_NUMBER_COUNT)) }
    }

    fun calculateStatistics(lottos: List<Lotto>, winningNumbers: Set<Int>, bonusNumber: Int): Map<String, Int> {
        val statistics = mutableMapOf(
            Constants.MATCH_3_DESCRIPTION to 0,
            Constants.MATCH_4_DESCRIPTION to 0,
            Constants.MATCH_5_DESCRIPTION to 0,
            Constants.MATCH_5_BONUS_DESCRIPTION to 0,
            Constants.MATCH_6_DESCRIPTION to 0
        )

        lottos.forEach { lotto ->
            val matchCount = lotto.getNumbers().count { winningNumbers.contains(it) }
            when (matchCount) {
                6 -> statistics[Constants.MATCH_6_DESCRIPTION] = statistics.getValue(Constants.MATCH_6_DESCRIPTION) + 1
                5 -> if (lotto.getNumbers().contains(bonusNumber)) {
                    statistics[Constants.MATCH_5_BONUS_DESCRIPTION] = statistics.getValue(Constants.MATCH_5_BONUS_DESCRIPTION) + 1
                } else {
                    statistics[Constants.MATCH_5_DESCRIPTION] = statistics.getValue(Constants.MATCH_5_DESCRIPTION) + 1
                }
                4 -> statistics[Constants.MATCH_4_DESCRIPTION] = statistics.getValue(Constants.MATCH_4_DESCRIPTION) + 1
                3 -> statistics[Constants.MATCH_3_DESCRIPTION] = statistics.getValue(Constants.MATCH_3_DESCRIPTION) + 1
            }
        }
        return statistics
    }

    fun calculateRateOfReturn(statistics: Map<String, Int>): Int {
        return statistics.entries.sumOf { (key, count) ->
            val prize = when (key) {
                Constants.MATCH_3_DESCRIPTION -> Constants.MATCH_3_PRIZE
                Constants.MATCH_4_DESCRIPTION -> Constants.MATCH_4_PRIZE
                Constants.MATCH_5_DESCRIPTION -> Constants.MATCH_5_PRIZE
                Constants.MATCH_5_BONUS_DESCRIPTION -> Constants.MATCH_5_BONUS_PRIZE
                Constants.MATCH_6_DESCRIPTION -> Constants.MATCH_6_PRIZE
                else -> 0
            }
            prize * count
        }
    }
}