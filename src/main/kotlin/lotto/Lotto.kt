package lotto

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange

enum class LottoRank(val prize: Int) {
    NONE(0),
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000)
}

class Lotto(private val numbers: List<Int>) {
    fun getLottoResultAsRank(winningNumbers: List<Int>, bonusNumber: Int): LottoRank {
        val matchCount = numbers.count { it in winningNumbers }

        return when (matchCount) {
            6 -> LottoRank.FIRST
            5 -> if (bonusNumber in numbers) LottoRank.SECOND else LottoRank.THIRD
            4 -> LottoRank.FOURTH
            3 -> LottoRank.FIFTH
            else -> LottoRank.NONE
        }
    }
}
