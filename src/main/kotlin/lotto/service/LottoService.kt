package lotto.service

import lotto.model.Lotto
import camp.nextstep.edu.missionutils.Randoms

class LottoService {
    fun purchaseLottos(amount: Int): List<Lotto> {
        val numberOfLottos = amount / 1000
        return List(numberOfLottos) { Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)) }
    }

    fun calculateStatistics(lottos: List<Lotto>, winningNumbers: Set<Int>, bonusNumber: Int): Map<String, Int> {
        val statistics = mutableMapOf(
            "3개 일치 (5,000원)" to 0,
            "4개 일치 (50,000원)" to 0,
            "5개 일치 (1,500,000원)" to 0,
            "5개 일치, 보너스 볼 일치 (30,000,000원)" to 0,
            "6개 일치 (2,000,000,000원)" to 0
        )

        lottos.forEach { lotto ->
            val matchCount = lotto.getNumbers().count { winningNumbers.contains(it) }
            when (matchCount) {
                6 -> statistics["6개 일치 (2,000,000,000원)"] = statistics.getValue("6개 일치 (2,000,000,000원)") + 1
                5 -> if (lotto.getNumbers().contains(bonusNumber)) {
                    statistics["5개 일치, 보너스 볼 일치 (30,000,000원)"] = statistics.getValue("5개 일치, 보너스 볼 일치 (30,000,000원)") + 1
                } else {
                    statistics["5개 일치 (1,500,000원)"] = statistics.getValue("5개 일치 (1,500,000원)") + 1
                }
                4 -> statistics["4개 일치 (50,000원)"] = statistics.getValue("4개 일치 (50,000원)") + 1
                3 -> statistics["3개 일치 (5,000원)"] = statistics.getValue("3개 일치 (5,000원)") + 1
            }
        }
        return statistics
    }

    fun calculateRateOfReturn(statistics: Map<String, Int>): Int {
        return statistics.entries.sumOf { (key, count) ->
            val prize = when (key) {
                "3개 일치 (5,000원)" -> 5000
                "4개 일치 (50,000원)" -> 50000
                "5개 일치 (1,500,000원)" -> 1_500_000
                "5개 일치, 보너스 볼 일치 (30,000,000원)" -> 30_000_000
                "6개 일치 (2,000,000,000원)" -> 2_000_000_000
                else -> 0
            }
            prize * count
        }
    }
}