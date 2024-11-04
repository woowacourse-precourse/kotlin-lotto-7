package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    var firstRank = 0
    var secondRank = 0
    var thirdRank = 0
    var fourthRank = 0
    var fifthRank = 0

    companion object {
        fun issueLotto(count: Int): List<List<Int>> {
            return (1..count).map {
                Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            }
        }
    }

    fun getLottoRank(myLotto: List<List<Int>>, bonusNumber: Int) {
        myLotto.forEach { lottoNumbers ->
            val matchCount = countMatchingNumbers(lottoNumbers, numbers.sorted())
            when {
                matchCount == 6 -> firstRank++
                matchCount == 5 && lottoNumbers.contains(bonusNumber) -> secondRank++
                matchCount == 5 -> thirdRank++
                matchCount == 4 -> fourthRank++
                matchCount == 3 -> fifthRank++
            }
        }
    }

    private fun countMatchingNumbers(list1: List<Int>, list2: List<Int>): Int {
        return list1.intersect(list2.toSet()).size
    }

    fun calculateProfitRate(purchaseAmount: Int): Double {
        val totalPrizeMoney =
            5000 * fifthRank + 50000 * fourthRank + 1500000 * thirdRank + 30000000 * secondRank + 2000000000 * firstRank
        return (totalPrizeMoney / purchaseAmount.toDouble()) * 100
    }
}
