package lotto

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange

enum class LottoRank {
    NONE,
    FIRST,
    SECOND,
    THIRD,
    FOURTH,
    FIFTH
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
