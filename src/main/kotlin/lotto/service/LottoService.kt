package lotto.service

import lotto.model.Lotto
import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.LottoMatchDescription
import lotto.utils.LottoMatchPrize
import lotto.utils.PurchaseAmount
import lotto.utils.WinningNumbers

class LottoService {
    fun purchaseLottos(amount: Int): List<Lotto> {
        val lottoCount = amount / PurchaseAmount.LOTTO_PRICE.value
        return List(lottoCount) { Lotto(Randoms.pickUniqueNumbersInRange(WinningNumbers.MIN_LOTTO_NUMBER.value, WinningNumbers.MAX_LOTTO_NUMBER.value, WinningNumbers.WINNING_NUMBER_COUNT.value)) }
    }

    fun calculateStatistics(lottos: List<Lotto>, winningNumbers: Set<Int>, bonusNumber: Int): Map<String, Int> {
        val statistics = initializeStatistics()

        lottos.forEach { lotto ->
            val matchCount = calculateMatchCount(lotto, winningNumbers)
            updateStatistics(statistics, matchCount, lotto, bonusNumber)
        }
        return statistics
    }

    private fun initializeStatistics(): MutableMap<String, Int> {
        return mutableMapOf(
            LottoMatchDescription.MATCH_3_DESCRIPTION.description to 0,
            LottoMatchDescription.MATCH_4_DESCRIPTION.description to 0,
            LottoMatchDescription.MATCH_5_DESCRIPTION.description to 0,
            LottoMatchDescription.MATCH_5_BONUS_DESCRIPTION.description to 0,
            LottoMatchDescription.MATCH_6_DESCRIPTION.description to 0
        )
    }

    private fun calculateMatchCount(lotto: Lotto, winningNumbers: Set<Int>): Int {
        return lotto.getNumbers().count { winningNumbers.contains(it) }
    }

    private fun updateStatistics(statistics: MutableMap<String, Int>, matchCount: Int, lotto: Lotto, bonusNumber: Int) {
        when (matchCount) {
            6 -> statistics[LottoMatchDescription.MATCH_6_DESCRIPTION.description] = statistics.getValue(LottoMatchDescription.MATCH_6_DESCRIPTION.description) + 1
            5 -> if (lotto.getNumbers().contains(bonusNumber)) {
                statistics[LottoMatchDescription.MATCH_5_BONUS_DESCRIPTION.description] = statistics.getValue(LottoMatchDescription.MATCH_5_BONUS_DESCRIPTION.description) + 1
            } else {
                statistics[LottoMatchDescription.MATCH_5_DESCRIPTION.description] = statistics.getValue(LottoMatchDescription.MATCH_5_DESCRIPTION.description) + 1
            }
            4 -> statistics[LottoMatchDescription.MATCH_4_DESCRIPTION.description] = statistics.getValue(LottoMatchDescription.MATCH_4_DESCRIPTION.description) + 1
            3 -> statistics[LottoMatchDescription.MATCH_3_DESCRIPTION.description] = statistics.getValue(LottoMatchDescription.MATCH_3_DESCRIPTION.description) + 1
        }
    }

    fun calculateRateOfReturn(statistics: Map<String, Int>): Int {
        return statistics.entries.sumOf { (key, count) ->
            val prize = when (key) {
                LottoMatchDescription.MATCH_3_DESCRIPTION.description -> LottoMatchPrize.MATCH_3_PRIZE.prize
                LottoMatchDescription.MATCH_4_DESCRIPTION.description -> LottoMatchPrize.MATCH_4_PRIZE.prize
                LottoMatchDescription.MATCH_5_DESCRIPTION.description -> LottoMatchPrize.MATCH_5_PRIZE.prize
                LottoMatchDescription.MATCH_5_BONUS_DESCRIPTION.description -> LottoMatchPrize.MATCH_5_BONUS_PRIZE.prize
                LottoMatchDescription.MATCH_6_DESCRIPTION.description -> LottoMatchPrize.MATCH_6_PRIZE.prize
                else -> 0
            }
            prize * count
        }
    }
}