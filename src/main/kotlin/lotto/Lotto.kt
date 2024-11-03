package lotto

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange

class Lotto(private val numbers: List<Int>) {
    fun getLottoResultAsRank(winningNumbers: List<Int>, bonusNumber: Int): Int {
        val matchCount = numbers.count { it in winningNumbers }

        return when (matchCount) {
            6 -> 1
            5 -> if (bonusNumber in numbers) 2 else 3
            4 -> 4
            3 -> 5
            else -> 6
        }
    }

}
